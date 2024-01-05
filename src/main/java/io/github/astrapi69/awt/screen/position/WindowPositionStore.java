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

import java.awt.Point;
import java.awt.Window;
import java.util.prefs.Preferences;

import io.github.astrapi69.awt.screen.ScreenSizeExtensions;
import lombok.NonNull;

/**
 * The class {@link WindowPositionStore} provides algorithms to store the Window position
 */
public class WindowPositionStore
{

	/**
	 * The reference to the window
	 */
	Window window;
	/**
	 * The reference to the class
	 */
	Class<?> clazz;

	/**
	 * The key for the width
	 */
	String widthKey;

	/**
	 * The key for the height
	 */
	String heightKey;

	/**
	 * The key for the X position
	 */
	String xPositionKey;

	/**
	 * The key for the Y position
	 */
	String yPositionKey;

	/**
	 * The default width
	 */
	int defaultWidth;
	/**
	 * The default height
	 */
	int defaultHeight;

	/**
	 * Instantiates a new {@link WindowPositionStore} object with the given parameters
	 *
	 * @param window
	 *            the window
	 * @param clazz
	 *            the clazz
	 */
	public WindowPositionStore(@NonNull final Window window, @NonNull final Class<?> clazz)
	{
		this(window, clazz, ComponentPositionPreference.DEFAULT_WIDTH,
			ComponentPositionPreference.DEFAULT_HEIGHT);
	}

	/**
	 * Instantiates a new {@link WindowPositionStore} object with the given parameters
	 *
	 * @param window
	 *            the window
	 * @param clazz
	 *            the clazz
	 * @param defaultWidth
	 *            the default width
	 * @param defaultHeight
	 *            the default height
	 */
	public WindowPositionStore(@NonNull final Window window, @NonNull final Class<?> clazz,
		final int defaultWidth, final int defaultHeight)
	{
		this.defaultWidth = defaultWidth;
		this.defaultHeight = defaultHeight;
		this.window = window;
		this.clazz = clazz;
		widthKey = clazz.getSimpleName() + ComponentPositionPreference.WIDTH.getKey();
		heightKey = clazz.getSimpleName() + ComponentPositionPreference.HEIGHT.getKey();
		xPositionKey = clazz.getSimpleName() + ComponentPositionPreference.X_POSITION.getKey();
		yPositionKey = clazz.getSimpleName() + ComponentPositionPreference.Y_POSITION.getKey();
	}

	/**
	 * Restores the window position from the preferences
	 */
	public void restorePosition()
	{
		Preferences preferences = Preferences.userNodeForPackage(clazz);
		int width = preferences.getInt(widthKey, this.defaultWidth);
		int height = preferences.getInt(heightKey, this.defaultHeight);

		int xPosition = (ScreenSizeExtensions.getScreenWidth() - width) / 2;
		int yPosition = (ScreenSizeExtensions.getScreenHeight() - height) / 2;

		xPosition = preferences.getInt(xPositionKey, xPosition);
		yPosition = preferences.getInt(yPositionKey, yPosition);
		ComponentPositionModel componentPositionModel = ComponentPositionModel.builder()
			.width(width).height(height).xPosition(xPosition).yPosition(yPosition).build();
		ScreenSizeExtensions.setWindowPosition(window, componentPositionModel);
	}

	/**
	 * Stores the window position to the preferences
	 */
	public void storePosition()
	{
		Point location = window.getLocation();
		Preferences preferences = Preferences.userNodeForPackage(clazz);

		int width = window.getWidth();
		int height = window.getHeight();

		int xPosition = (int)location.getX();
		int yPosition = (int)location.getY();

		preferences.putInt(widthKey, width);
		preferences.putInt(heightKey, height);
		preferences.putInt(xPositionKey, xPosition);
		preferences.putInt(yPositionKey, yPosition);
	}

}
