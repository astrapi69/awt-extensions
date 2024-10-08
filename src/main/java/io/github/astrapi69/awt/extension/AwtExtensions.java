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
package io.github.astrapi69.awt.extension;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.Clipboard;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The class {@link AwtExtensions}
 */
public final class AwtExtensions
{

	/**
	 * Private constructor to prevent instantiation
	 */
	private AwtExtensions()
	{
	}

	/**
	 * Gets the root JDialog from the given Component Object.
	 *
	 * @param component
	 *            The Component to find the root JDialog.
	 * @return 's the root JDialog.
	 */
	public static Component getRootJDialog(Component component)
	{
		while (null != component.getParent())
		{
			component = component.getParent();
			if (component instanceof JDialog)
			{
				break;
			}
		}
		return component;
	}

	/**
	 * Gets the root JFrame from the given Component Object.
	 *
	 * @param component
	 *            The Component to find the root JFrame.
	 * @return 's the root JFrame.
	 */
	public static Component getRootJFrame(Component component)
	{
		while (null != component.getParent())
		{
			component = component.getParent();
			if (component instanceof JFrame)
			{
				break;
			}
		}
		return component;
	}

	/**
	 * Gets the root parent from the given Component Object.
	 *
	 * @param component
	 *            The Component to find the root parent.
	 * @return 's the root parent.
	 */
	public static Component getRootParent(Component component)
	{
		while (null != component.getParent())
		{
			component = component.getParent();
		}
		return component;
	}

	/**
	 * Gets the toplevel <code>Frame</code> or <code>Dialog</code>
	 *
	 * @param component
	 *            the parent component
	 * @return the the toplevel <code>Frame</code> or <code>Dialog</code>
	 * @throws HeadlessException
	 *             if <code>GraphicsEnvironment.isHeadless</code> returns <code>true</code>
	 * @see GraphicsEnvironment#isHeadless
	 */
	public static Window getWindowForComponent(Component component) throws HeadlessException
	{
		if (component == null)
		{
			return JOptionPane.getRootFrame();
		}
		if (component instanceof Frame || component instanceof Dialog)
		{
			return (Window)component;
		}
		return getWindowForComponent(component.getParent());
	}

	/**
	 * Creates an invisible cursor.
	 *
	 * @return s the created invisible cursor.
	 */
	public static Cursor newInvisibleCursor()
	{
		return Toolkit.getDefaultToolkit().createCustomCursor(
			Toolkit.getDefaultToolkit().createImage(new byte[0]), new Point(0, 0),
			"InvisibleCursor");
	}

	/**
	 * Gets the {@link Clipboard} of the system
	 *
	 * @return s the {@link Clipboard} of the system
	 */
	public static Clipboard getSystemClipboard()
	{
		return Toolkit.getDefaultToolkit().getSystemClipboard();
	}

}
