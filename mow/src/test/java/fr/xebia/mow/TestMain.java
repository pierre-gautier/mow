/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow;

import java.io.ByteArrayInputStream;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import fr.xebia.mow.model.Main;
import fr.xebia.mow.model.ParsingException;

/**
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 *
 */
public class TestMain {

    private static final int size = 9999;

    @Test
    public void test() {
        Exception expected = null;
        try {
            Main.main(null);
        } catch (final Exception e) {
            expected = e;
        }
        Assert.assertNotNull(expected);
        expected = null;
        try {
            Main.main(new String[] {});
        } catch (final Exception e) {
            expected = e;
        }
        Assert.assertNotNull(expected);
        expected = null;
        try {
            Main.main(new String[] { "src\\test\\resources\\test.txt", "rulesFileHere" });
        } catch (final Exception e) {
            expected = e;
        }
        Assert.assertNotNull(expected);
        expected = null;
        try {
            Main.main(new String[] { "src\\test\\resources\\test.txt" });
        } catch (final Exception e) {
            expected = e;
        }
        Assert.assertNull(expected);
    }

    @Test
    public void testBig() {

        final StringBuilder builder = new StringBuilder();
        builder.append(TestMain.size).append(" ").append(TestMain.size).append("\n");
        for (int i = 0; i < 100; i++) {
            builder.append(new Random().nextInt(TestMain.size)).append(" ").append(new Random().nextInt(TestMain.size)).append(" ").append("N").append("\n");
            builder.append(this.randomCommands(1000)).append("\n");
        }

        Exception expected = null;
        try {
            final long start = System.currentTimeMillis();
            Main.parse(new ByteArrayInputStream(builder.toString().getBytes()));
            System.err.println("running big : " + (System.currentTimeMillis() - start) + "ms");
        } catch (final ParsingException e) {
            expected = e;
        }
        Assert.assertNull(expected);

    }

    private String randomCommands(final int size) {
        final StringBuilder builder = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            final int rand = new Random().nextInt(3);
            builder.append(rand == 0 ? "A" : rand == 1 ? "G" : "D");
        }
        return builder.toString();
    }

}
