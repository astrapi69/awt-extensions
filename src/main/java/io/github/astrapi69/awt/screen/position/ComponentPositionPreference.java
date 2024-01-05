/**
 * The MIT License
 *
 * Copyright (C) 2022 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.awt.screen.position;

import lombok.Getter;

/**
 * The enum {@link ComponentPositionPreference} holds the key suffixes that will be saved in the
 * preferences and the default with and height
 */
@Getter
public enum ComponentPositionPreference
{

	/**
	 * The enum for the width window position key for the preference
	 */
	WIDTH(".width"),

	/**
	 * The enum for the height window position key for the preference
	 */
	HEIGHT(".height"),

	/**
	 * The enum for the X position window position key for the preference
	 */
	X_POSITION(".xposition"),

	/**
	 * The enum for the Y position window position key for the preference
	 */
	Y_POSITION(".yposition");

	/**
	 * The constant for the default width
	 */
	public static final int DEFAULT_WIDTH = 500;

	/**
	 * The constant for the default height
	 */
	public static final int DEFAULT_HEIGHT = 500;

	/**
	 * The Key.
	 */
	private final String key;

	ComponentPositionPreference(final String key)
	{
		this.key = key;
	}
}
