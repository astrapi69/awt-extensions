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

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * The ui test class for the class {@link ComponentPositionStore}
 */
public class ComponentPositionStoreTest
{

	/**
	 * Test the class {@link ComponentPositionStore}
	 *
	 * @param args
	 *            the args
	 */
	public static void main(final String[] args)
	{
		// create a component for instance a JFrame...
		JFrame frame = new JFrame();
		// create a store for the component position
		final ComponentPositionStore componentPositionStore = new ComponentPositionStore(frame,
			ComponentPositionStoreTest.class, 600, 500);
		// restore the component position...
		componentPositionStore.restorePosition();
		// add a shutdown hook...
		Runtime.getRuntime()
			.addShutdownHook(new Thread(() -> componentPositionStore.storePosition()));
		// show the frame...
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}
}