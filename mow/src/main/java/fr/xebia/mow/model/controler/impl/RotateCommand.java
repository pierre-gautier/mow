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

import fr.xebia.mow.model.ECardinal;
import fr.xebia.mow.model.EMove;
import fr.xebia.mow.model.ERotation;
import fr.xebia.mow.model.IMap;
import fr.xebia.mow.model.IMow;
import fr.xebia.mow.model.IPositionnedObject;
import fr.xebia.mow.model.Point;
import fr.xebia.mow.model.controler.IRule;

/**
 * The Class RotateCommand.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public class RotateCommand extends ACommand {

    private final ERotation rotation;

    /**
     * Create a command applying the given rotation.
     *
     * @param rotation
     *            the rotation
     */
    public RotateCommand(final ERotation rotation) {
        this.rotation = rotation;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.controler.impl.ACommand#execute(fr.xebia.mow.IMow, fr.xebia.mow.IMap, java.util.Collection)
     */
    @Override
    public void execute(final IMow mow, final IMap map, final Collection<IRule> rules) {
        final ECardinal newDirection = this.rotation.apply(mow.getDirection());
        final Point pointForward = mow.getPosition().plus(EMove.FORWARD.apply(newDirection));
        final Collection<IPositionnedObject> objectsForward = map.get(pointForward);
        for (final IRule rule : rules) {
            if (rule.applyTo(this) && !rule.allow(objectsForward)) {
                return;
            }
        }
        mow.rotate(this.rotation);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return RotateCommand.class.getSimpleName() + " " + this.rotation; //$NON-NLS-1$
    }

}
