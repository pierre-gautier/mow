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

import fr.xebia.mow.model.IMap;
import fr.xebia.mow.model.IMow;
import fr.xebia.mow.model.controler.ICommand;
import fr.xebia.mow.model.controler.IRule;

/**
 * The Class ACommand.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public abstract class ACommand implements ICommand {

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.controler.ICommand#execute(fr.xebia.mow.IMow, fr.xebia.mow.IMap, java.util.Collection)
     */
    @Override
    public abstract void execute(final IMow mow, final IMap map, final Collection<IRule> rules);

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.controler.ICommand#undo()
     */
    @Override
    public void undo() {
        // cannot be undone
    }

}
