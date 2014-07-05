package com.mrgreaper.twistedmod2.items;

/**
 * Created by david on 23/06/2014.
 */
public class itemTwistedHammer extends twistedItems {//by having it extend our item we can despense with some of the duplicated methods and just add the additional/different ones in.

    public itemTwistedHammer() {
        super();
        this.maxStackSize = 1;
        this.setMaxDamage(64); //use it 64 times until it breaks
        this.setNoRepair();
    }
}
