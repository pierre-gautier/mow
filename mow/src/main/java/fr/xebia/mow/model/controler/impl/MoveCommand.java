/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow.model.controler.impl;

import java.util.Collection;

import fr.xebia.mow.model.EMove;
import fr.xebia.mow.model.IMap;
import fr.xebia.mow.model.IMow;
import fr.xebia.mow.model.IPositionnedObject;
import fr.xebia.mow.model.Point;
import fr.xebia.mow.model.controler.IRule;

/**
 * The Class MoveCommand.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public class MoveCommand extends ACommand {

    private final EMove move;

    /**
     * Instantiates a new move command.
     *
     * @param move
     *            the move
     */
    public MoveCommand(final EMove move) {
        this.move = move;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.controler.impl.ACommand#execute(fr.xebia.mow.IMow, fr.xebia.mow.IMap, java.util.Collection)
     */
    @Override
    public void execute(final IMow mow, final IMap map, final Collection<IRule> rules) {
        final Point pointTo = this.move.apply(mow.getDirection());
        final Point validTo = map.apply(mow.getPosition(), pointTo);
        final Collection<IPositionnedObject> objectsForward = map.get(validTo);
        for (final IRule rule : rules) {
            if (rule.applyTo(this) && !rule.allow(objectsForward)) {
                return;
            }
        }
        mow.move(validTo);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoveCommand.class.getSimpleName() + " " + this.move; //$NON-NLS-1$
    }

}
