/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow.model.controler.impl.parser;

import java.util.ArrayList;
import java.util.Collection;

import fr.xebia.mow.model.EMove;
import fr.xebia.mow.model.ERotation;
import fr.xebia.mow.model.IParser;
import fr.xebia.mow.model.ParsingException;
import fr.xebia.mow.model.controler.ICommand;
import fr.xebia.mow.model.controler.impl.MoveCommand;
import fr.xebia.mow.model.controler.impl.RotateCommand;

/**
 * A decent evolution would be to use a factory to instanciate Commands
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public class CommandsParser implements IParser<Collection<ICommand>> {

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.io.IParser#parse(java.lang.String)
     */
    @Override
    public Collection<ICommand> parse(final String input) throws ParsingException {
        if (input == null || input.trim().isEmpty()) {
            throw new ParsingException("input cannot be null, empty or blank"); //$NON-NLS-1$
        }
        final Collection<ICommand> commands = new ArrayList<>(input.length());
        for (int i = 0; i < input.length(); i++) {
            final char label = input.charAt(i);
            final ERotation rotation = ERotation.fromLabel(label);
            if (rotation != null) {
                commands.add(new RotateCommand(rotation));
                continue;
            }
            final EMove move = EMove.fromLabel(label);
            if (move != null) {
                commands.add(new MoveCommand(move));
                continue;
            }
            throw new ParsingException("input contains an invalid character '" + label + "'"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        return commands;
    }

}
