package com.mrgreaper.twistedmod2.reference;

import com.mrgreaper.twistedmod2.items.OCdriverCardSpeaky;

/**
 * Created by david on 03/08/2014.
 */
public class OCdriverBootUp {

    public static void init() {
        li.cil.oc.api.Driver.add(new OCdriverCardSpeaky());
    }
}
