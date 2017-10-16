/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import fr.xebia.mow.model.controler.ICommand;
import fr.xebia.mow.model.controler.MowControler;
import fr.xebia.mow.model.controler.impl.parser.CommandsParser;
import fr.xebia.mow.model.impl.parser.RectangularMapParser;
import fr.xebia.mow.model.impl.parser.StandardMowParser;

/**
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 *
 */
public class Main {

    /**
     * @param args
     * @throws IOException
     * @throws ParsingException
     */
    public static void main(final String[] args) throws IOException, ParsingException {
        if (args == null || args.length != 1 || args[0].trim().isEmpty()) {
            throw new IllegalArgumentException("Usage java -jar mow.jar file-path"); //$NON-NLS-1$
        }
        try (InputStream inputStream = new FileInputStream(new File(args[0]))) {
            final Collection<MowControler> controlers = Main.parse(inputStream);
            for (final MowControler controler : controlers) {
                controler.run();
                controler.display();
            }
        }
    }

    /**
     * @param stream
     * @return the parsed mow controlers
     * @throws ParsingException
     */
    public static List<MowControler> parse(final InputStream stream) throws ParsingException {
        final IParser<IMow> mowParser = new StandardMowParser();
        final IParser<IMap> mapParser = new RectangularMapParser();
        final IParser<Collection<ICommand>> commandsParser = new CommandsParser();
        final List<MowControler> controlers = new LinkedList<>();
        try (final Scanner scanner = new Scanner(stream)) {
            final String mapLine = scanner.nextLine();
            final IMap map = mapParser.parse(mapLine);
            while (scanner.hasNextLine()) {
                final IMow mow = mowParser.parse(scanner.nextLine());
                controlers.add(new MowControler(mow, map, commandsParser.parse(scanner.nextLine())));
            }
        } catch (final NoSuchElementException e) {
            throw new ParsingException("Invalid input: a line is missing"); //$NON-NLS-1$
        } catch (final Exception e) {
            throw new ParsingException("Invalid input: unexpected error"); //$NON-NLS-1$
        }
        return controlers;
    }

}
