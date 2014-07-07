package com.mrgreaper.twistedmod2.handlers;

import com.mrgreaper.twistedmod2.utility.LogHelper;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

/**
 * Created by david on 23/06/2014.
 */
public class SpeechThreaded implements Runnable {

    private static double vVoice;
    private static float vPitch;
    private static float vPitchRange;
    private static float vPitchShift;
    private static String vSentence;

    public static void speechSynth(double vVoice2, float vPitch2, float vPitchRange2, float vPitchShift2, String vSentence2) {
        vVoice = vVoice2;
        vPitch = vPitch2;
        vPitchRange = vPitchRange2;
        vPitchShift = vPitchShift2;
        vSentence = vSentence2;
        LogHelper.info(" set the values to " + vVoice + " " + vPitch + " " + vPitchRange + " " + vPitchShift + " " + vSentence);


        Thread t1 = new Thread(new SpeechThreaded());

        t1.start();

    }

    @Override
    public void run() {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        System.out.println(" about to try " + vVoice + " " + vPitch + " " + vPitchRange + " " + vPitchShift + " " + vSentence);
        try {
            String VOICENAME = "kevin16";
            if (vVoice == 1) {
                VOICENAME = "kevin";
            }
            ; //for now we wont use the low quality one, it would proberly not be used much and thus the removal of an augment will help players
            if (vVoice == 2) {
                VOICENAME = "kevin16";
            }
            ;
            //if (vVoice == 3) {VOICENAME = "alan";}; //REMed out as alan can only talk about the time
            Voice voice;
            VoiceManager vm = VoiceManager.getInstance();
            voice = vm.getVoice(VOICENAME);
            voice.allocate();
            voice.setPitch(vPitch);
            voice.setPitchRange(vPitchRange);
            voice.setPitchShift(vPitchShift);
            voice.speak(vSentence);
            return;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
