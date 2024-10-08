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
package io.github.astrapi69.awt.screen;

import java.awt.Component;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.util.Optional;

import javax.swing.JFrame;

/**
 * The class {@link GraphicsDeviceExtensions} helps you if the user has more than one screen to
 * determine which screen is currently shown.
 */
public final class GraphicsDeviceExtensions
{

	/**
	 * Private constructor to prevent instantiation
	 */
	private GraphicsDeviceExtensions()
	{
	}

	/**
	 * Gets the available screens.
	 *
	 * @return the available screens
	 */
	public static GraphicsDevice[] getAvailableScreens()
	{
		final GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment
			.getLocalGraphicsEnvironment();
		final GraphicsDevice[] graphicsDevices = graphicsEnvironment.getScreenDevices();
		return graphicsDevices;
	}

	/**
	 * Gets the {@link Optional} with an {@link GraphicsDevice} in it or if it does not exist the
	 * {@link Optional} object is empty.
	 *
	 * @param index
	 *            the index
	 * @return the {@link Optional} with an {@link GraphicsDevice} in it or if it does not exist the
	 *         {@link Optional} object is empty.
	 */
	public static Optional<GraphicsDevice> getGraphicsDevice(final int index)
	{
		if (isScreenAvailableToShow(index))
		{
			final GraphicsDevice[] graphicsDevices = getAvailableScreens();
			return Optional.of(graphicsDevices[index]);
		}
		return Optional.empty();
	}

	/**
	 * Gets the array index(in the available {@link GraphicsDevice} array) of the given component is
	 * showing on.
	 *
	 * @param component
	 *            the component
	 * @return the array index(in the available {@link GraphicsDevice} array) of the given component
	 *         is showing on.
	 */
	public static int getGraphicsDeviceIndexIsShowingOn(final Component component)
	{
		int graphicsDeviceIndex = -1;
		final GraphicsDevice graphicsDevice = getGraphicsDeviceIsShowingOn(component);
		final GraphicsDevice[] graphicsDevices = getAvailableScreens();
		for (int i = 0; i < graphicsDevices.length; i++)
		{
			if (graphicsDevices[i].equals(graphicsDevice))
			{
				graphicsDeviceIndex = i;
				break;
			}
		}
		return graphicsDeviceIndex;
	}


	/**
	 * Gets the graphics device (screen) is showing on.
	 *
	 * @param component
	 *            the component
	 * @return the graphics device is showing on
	 */
	public static GraphicsDevice getGraphicsDeviceIsShowingOn(final Component component)
	{
		final GraphicsDevice graphicsDevice = component.getGraphicsConfiguration().getDevice();
		return graphicsDevice;
	}


	/**
	 * Checks if the given screen number is available to show.
	 *
	 * @param screen
	 *            the screen
	 * @return true, if is screen available to show
	 */
	public static boolean isScreenAvailableToShow(final int screen)
	{
		final GraphicsDevice[] graphicsDevices = getAvailableScreens();
		return graphicsDevices.length > 0 && screen > -1 && screen < graphicsDevices.length;
	}

	/**
	 * If the screen is available, the given window will be shown in the given screen
	 *
	 * @param <T>
	 *            the generic type of the window
	 * @param screen
	 *            the screen number.
	 * @param window
	 *            the window
	 */
	public static <T extends Window> void showOnScreen(final int screen, final T window)
	{
		if (isScreenAvailableToShow(screen))
		{
			final GraphicsDevice[] graphicsDevices = getAvailableScreens();
			graphicsDevices[screen].setFullScreenWindow(window);
		}
	}
}
