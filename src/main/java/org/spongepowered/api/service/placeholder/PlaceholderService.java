/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.service.placeholder;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.event.game.GameRegistryEvent;
import org.spongepowered.api.service.ServiceManager;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.text.channel.MessageReceiver;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * A service that handles the parsing of placeholder tokens. This service is
 * replaceable in the {@link ServiceManager}.
 *
 * <p>Plugins requesting the use of a placeholder should use the methods
 * supplied by this service to construct {@link PlaceholderText} which can
 * be used in {@link Text}.</p>
 *
 * <p>Plugins wishing to supply placeholders should supply them via the
 * appropriate {@link GameRegistryEvent.Register} event or via
 * {@link GameRegistry#register(Class, CatalogType)}.</p>
 *
 * <p>This service makes no assumption about how a plugin parses/tokenizes a
 * string in order to determine what placeholders to use.</p>
 */
public interface PlaceholderService {

    /**
     * Gets a {@link PlaceholderText} based on the provided token.
     *
     * <p>It is entirely up to the implementation of the service to determine
     * how to select a placeholder if the supplied {@code token} is not a
     * known ID for a registered {@link PlaceholderParser}.</p>
     *
     * @param token The token to obtain.
     * @return The parsed {@link Text}.
     */
    default Optional<PlaceholderText> parse(String token) {
        return this.parse(token, "", null);
    }

    /**
     * Gets a {@link PlaceholderText} based on the provided token,
     * using the provided {@link MessageReceiver} for context.
     *
     * <p>It is entirely up to the implementation of the service to determine
     * how to select a placeholder if the supplied {@code token} is not a
     * known ID for a registered {@link PlaceholderParser}.</p>
     *
     * @param token The token to obtain.
     * @param messageReceiver The source that tokens should use as a context.
     *  May be {@code null}, but some tokens may not parse without this
     *  supplied.
     * @return The parsed {@link Text}.
     */
    default Optional<PlaceholderText> parse(String token, @Nullable MessageReceiver messageReceiver) {
        return this.parse(token, "", messageReceiver);
    }

    /**
     * Gets a {@link PlaceholderText} based on the provided token,
     * using the provided {@link MessageReceiver} and supplied argument string
     * for context.
     *
     * <p>It is entirely up to the implementation of the service to determine
     * how to select a placeholder if the supplied {@code token} is not a
     * known ID for a registered {@link PlaceholderParser}.</p>
     *
     * @param token The token name.
     * @param arguments The arguments for the token.
     * @return The parsed {@link TextRepresentable}, if any.
     */
    default Optional<PlaceholderText> parse(String token, String arguments) {
        return this.parse(token, arguments, null);
    }

    /**
     * Gets a {@link PlaceholderText} based on the provided token,
     * using the provided {@link MessageReceiver} and supplied argument string
     * for context.
     *
     * <p>It is entirely up to the implementation of the service to determine
     * how to select a placeholder if the supplied {@code token} is not a
     * known ID for a registered {@link PlaceholderParser}.</p>
     *
     * @param token The token name.
     * @param arguments The arguments for the token.
     * @param messageReceiver The source that tokens should use as a context.
     *  May be {@code null}, but some tokens may not parse without this
     *  supplied.
     * @return The parsed {@link TextRepresentable}, if any.
     */
    Optional<PlaceholderText> parse(String token, String arguments, @Nullable MessageReceiver messageReceiver);

    /**
     * Returns a builder that creates a {@link PlaceholderText} for use in
     * {@link Text} objects.
     *
     * @return A {@link PlaceholderText.Builder}
     */
    PlaceholderText.Builder placeholderBuilder();

}
