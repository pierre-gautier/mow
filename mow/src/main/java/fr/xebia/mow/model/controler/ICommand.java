/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow.model.controler;

import java.util.Collection;

import fr.xebia.mow.model.IMap;
import fr.xebia.mow.model.IMow;

/**
 * The Interface ICommand.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public interface ICommand {

    /**
     * Execute.
     *
     * @param mow
     *            the mow
     * @param map
     *            the map
     * @param rules
     *            the rules
     */
    void execute(IMow mow, IMap map, Collection<IRule> rules);

    /**
     * Undo.
     */
    void undo();
}
