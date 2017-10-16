/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow.model;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum ERotation.
 *
 * A decent evolution would be to internationalize the constants label.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public enum ERotation {

    /** The right. */
    RIGHT('D', ECardinal.NORTH, ECardinal.EAST, ECardinal.SOUTH, ECardinal.WEST),

    /** The left. */
    LEFT('G', ECardinal.NORTH, ECardinal.WEST, ECardinal.SOUTH, ECardinal.EAST);

    /**
     * From label.
     *
     * @param label
     *            the label
     * @return the rotation
     */
    public static ERotation fromLabel(final char label) {
        for (final ERotation value : ERotation.values()) {
            if (value.label == label) {
                return value;
            }
        }
        return null;
    }

    private final Map<ECardinal, ECardinal> mapping = new HashMap<>();
    private final char                      label;

    private ERotation(final char label, final ECardinal... sequence) {
        this.label = label;
        for (int i = 0; i < sequence.length - 1; i++) {
            this.mapping.put(sequence[i], sequence[i + 1]);
        }
        this.mapping.put(sequence[sequence.length - 1], sequence[0]);
    }

    /**
     * Apply.
     *
     * @param cardinal
     *            on which apply the direction
     * @return the cardinal obtained
     */
    public ECardinal apply(final ECardinal cardinal) {
        return this.mapping.get(cardinal);
    }

    @Override
    public String toString() {
        return String.valueOf(this.label);
    }

}
