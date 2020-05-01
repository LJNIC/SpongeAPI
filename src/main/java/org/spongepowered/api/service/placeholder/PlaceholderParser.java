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
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * Provides the logic of how to parse a placeholder token.
 */
@CatalogedBy(PlaceholderParsers.class)
public interface PlaceholderParser extends CatalogType {

    /**
     * Creates a {@link Text} based on the provided {@link PlaceholderText}.
     *
     * <p>This method should not throw an error, instead returning
     * {@link Text#EMPTY} if the supplied {@link PlaceholderText} is not
     * valid.</p>
     *
     * @param placeholderText The {@link PlaceholderText}
     * @return The {@link Text}
     */
    Text parse(PlaceholderText placeholderText);

}
