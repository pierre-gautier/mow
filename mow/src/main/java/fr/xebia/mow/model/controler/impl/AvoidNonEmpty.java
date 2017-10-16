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

import fr.xebia.mow.model.IPositionnedObject;
import fr.xebia.mow.model.controler.ICommand;
import fr.xebia.mow.model.controler.IRule;

/**
 * This class implements a rule to avoid any kind of specified {@link IPositionnedObject}.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public class AvoidNonEmpty implements IRule {

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.controler.IRule#allow(java.util.Collection)
     */
    @Override
    public boolean allow(final Collection<IPositionnedObject> existing) {
        return existing.isEmpty();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.controler.IRule#applyTo(fr.xebia.mow.controler.ICommand)
     */
    @Override
    public boolean applyTo(final ICommand command) {
        return command instanceof MoveCommand;
    }

}
