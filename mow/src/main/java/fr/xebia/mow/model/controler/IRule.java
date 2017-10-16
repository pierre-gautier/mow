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

import fr.xebia.mow.model.IPositionnedObject;

/**
 * The Interface IRule.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public interface IRule {

    /**
     * Allow.
     *
     * @param existing
     *            the existing
     * @return true, if successful
     */
    boolean allow(Collection<IPositionnedObject> existing);

    /**
     * Apply to.
     *
     * @param command
     *            the command
     * @return true, if successful
     */
    boolean applyTo(ICommand command);

}
