/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import fr.xebia.mow.model.ECardinal;
import fr.xebia.mow.model.IMap;
import fr.xebia.mow.model.IMow;
import fr.xebia.mow.model.IParser;
import fr.xebia.mow.model.ParsingException;
import fr.xebia.mow.model.Point;
import fr.xebia.mow.model.controler.ICommand;
import fr.xebia.mow.model.controler.impl.parser.CommandsParser;
import fr.xebia.mow.model.impl.RectangularMap;
import fr.xebia.mow.model.impl.StandardMow;
import fr.xebia.mow.model.impl.parser.RectangularMapParser;
import fr.xebia.mow.model.impl.parser.StandardMowParser;

/**
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 *
 */
public class TestParsers {

    @Test
    public void testCommandParser() {
        final IParser<Collection<ICommand>> parser = new CommandsParser();
        this.parseInvalid(parser, null);
        this.parseInvalid(parser, "");
        this.parseInvalid(parser, "12");
        this.parseInvalid(parser, "a b");
        this.parseInvalid(parser, "1 b");
        this.parseInvalid(parser, "a 2");
        try {
            final Collection<ICommand> commands = parser.parse("ADG");
            Assert.assertTrue(commands instanceof Collection);
            Assert.assertEquals(3, commands.size());
        } catch (final ParsingException e) {
            Assert.fail("exception should not be thrown");
        }
    }

    @Test
    public void testMapParser() {
        final IParser<IMap> parser = new RectangularMapParser();
        this.parseInvalid(parser, null);
        this.parseInvalid(parser, "");
        this.parseInvalid(parser, "12");
        this.parseInvalid(parser, "a b");
        this.parseInvalid(parser, "1 b");
        this.parseInvalid(parser, "a 2");
        try {
            final IMap map = parser.parse("5 5");
            Assert.assertTrue(map instanceof RectangularMap);
            Assert.assertEquals(Point.create(6, 6), map.getSize());
        } catch (final ParsingException e) {
            Assert.fail("exception should not be thrown");
        }
    }

    @Test
    public void testMowParser() {
        final IParser<IMow> parser = new StandardMowParser();
        this.parseInvalid(parser, null);
        this.parseInvalid(parser, "");
        this.parseInvalid(parser, "12");
        this.parseInvalid(parser, "a b");
        this.parseInvalid(parser, "1 b");
        this.parseInvalid(parser, "a 2");
        this.parseInvalid(parser, "1 2 3");
        this.parseInvalid(parser, "1 2 U");
        this.parseInvalid(parser, "NORTH 1 2 ");
        try {
            final IMow mow = parser.parse("5 5 NORTH");
            Assert.assertTrue(mow instanceof StandardMow);
            Assert.assertEquals(Point.create(5, 5), mow.getPosition());
            Assert.assertEquals(ECardinal.NORTH, mow.getDirection());

            final IMow mow2 = parser.parse("1 2 WEST");
            Assert.assertTrue(mow2 instanceof StandardMow);
            Assert.assertEquals(Point.create(1, 2), mow2.getPosition());
            Assert.assertEquals(ECardinal.WEST, mow2.getDirection());
        } catch (final ParsingException e) {
            Assert.fail("exception should not be thrown");
        }
    }

    protected void parseInvalid(final IParser parser, final String input) {
        Exception expected = null;
        try {
            parser.parse(input);
        } catch (final ParsingException e) {
            expected = e;
        }
        Assert.assertNotNull(expected);
    }

}
