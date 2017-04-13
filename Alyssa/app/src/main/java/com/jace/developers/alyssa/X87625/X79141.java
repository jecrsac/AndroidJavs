package com.jace.developers.alyssa.X87625;


import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class X79141 {

    public List<X77940> X335987082(InputStream in) throws IOException {
        JsonReader r = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try { return X917187100(r); } finally { r.close(); }
    }

    private List<X77940> X917187100(JsonReader r) throws IOException {

        ArrayList<X77940> X80950 = new ArrayList<>();
        r.beginArray();
        while (r.hasNext()) {
            X80950.add(X169987233(r));
        }
        r.endArray();
        return X80950;
    }

    private X77940 X169987233(JsonReader r) throws IOException {

        String XBDC00 = null, XBDC01 = null, XBDC02 = null, XBDC03 = null, XBDC04 = null, XBDC05 = null;
        String XBDC06 = null, XBDC07 = null, XBDC08 = null, XBDC09 = null, XBDC10 = null, XBDC11 = null;
        String XBDC12 = null, XBDC13 = null, XBDC14 = null, XBDC15 = null, XBDC16 = null, XBDC17 = null;
        String XBDC18 = null, XBDC19 = null, XBDC20 = null, XBDC21 = null, XBDC22 = null, XBDC23 = null;
        String XBDC24 = null, XBDC25 = null, XBDC26 = null, XBDC27 = null, XBDC28 = null, XBDC29 = null;
        String XBDC30 = null, XBDC31 = null, XBDC32 = null, XBDC33 = null, XBDC34 = null, XBDC35 = null;
        String XBDC36 = null, XBDC37 = null, XBDC38 = null, XBDC39 = null, XBDC40 = null, XBDC41 = null;
        String XBDC42 = null, XBDC43 = null, XBDC44 = null, XBDC45 = null, XBDC46 = null, XBDC47 = null;
        String XBDC48 = null, XBDC49 = null;

        r.beginObject();

        while (r.hasNext()) {
            String name = r.nextName();
            switch (name) {
                case "XBDC00": XBDC00 = r.nextString(); break; case "XBDC01": XBDC01 = r.nextString(); break;
                case "XBDC02": XBDC02 = r.nextString(); break; case "XBDC03": XBDC03 = r.nextString(); break;
                case "XBDC04": XBDC04 = r.nextString(); break; case "XBDC05": XBDC05 = r.nextString(); break;
                case "XBDC06": XBDC06 = r.nextString(); break; case "XBDC07": XBDC07 = r.nextString(); break;
                case "XBDC08": XBDC08 = r.nextString(); break; case "XBDC09": XBDC09 = r.nextString(); break;
                case "XBDC10": XBDC10 = r.nextString(); break; case "XBDC11": XBDC11 = r.nextString(); break;
                case "XBDC12": XBDC12 = r.nextString(); break; case "XBDC13": XBDC13 = r.nextString(); break;
                case "XBDC14": XBDC14 = r.nextString(); break; case "XBDC15": XBDC15 = r.nextString(); break;
                case "XBDC16": XBDC16 = r.nextString(); break; case "XBDC17": XBDC17 = r.nextString(); break;
                case "XBDC18": XBDC18 = r.nextString(); break; case "XBDC19": XBDC19 = r.nextString(); break;
                case "XBDC20": XBDC20 = r.nextString(); break; case "XBDC21": XBDC21 = r.nextString(); break;
                case "XBDC22": XBDC22 = r.nextString(); break; case "XBDC23": XBDC23 = r.nextString(); break;
                case "XBDC24": XBDC24 = r.nextString(); break; case "XBDC25": XBDC25 = r.nextString(); break;
                case "XBDC26": XBDC26 = r.nextString(); break; case "XBDC27": XBDC27 = r.nextString(); break;
                case "XBDC28": XBDC28 = r.nextString(); break; case "XBDC29": XBDC29 = r.nextString(); break;
                case "XBDC30": XBDC30 = r.nextString(); break; case "XBDC31": XBDC31 = r.nextString(); break;
                case "XBDC32": XBDC32 = r.nextString(); break; case "XBDC33": XBDC33 = r.nextString(); break;
                case "XBDC34": XBDC34 = r.nextString(); break; case "XBDC35": XBDC35 = r.nextString(); break;
                case "XBDC36": XBDC36 = r.nextString(); break; case "XBDC37": XBDC37 = r.nextString(); break;
                case "XBDC38": XBDC38 = r.nextString(); break; case "XBDC39": XBDC39 = r.nextString(); break;
                case "XBDC40": XBDC40 = r.nextString(); break; case "XBDC41": XBDC41 = r.nextString(); break;
                case "XBDC42": XBDC42 = r.nextString(); break; case "XBDC43": XBDC43 = r.nextString(); break;
                case "XBDC44": XBDC44 = r.nextString(); break; case "XBDC45": XBDC45 = r.nextString(); break;
                case "XBDC46": XBDC46 = r.nextString(); break; case "XBDC47": XBDC47 = r.nextString(); break;
                case "XBDC48": XBDC48 = r.nextString(); break; case "XBDC49": XBDC49 = r.nextString(); break;
                default:
                    r.skipValue();
                    break;
            }
        }
        r.endObject();
        return new X77940(
                XBDC00, XBDC01, XBDC02, XBDC03, XBDC04, XBDC05,
                XBDC06, XBDC07, XBDC08, XBDC09, XBDC10, XBDC11,
                XBDC12, XBDC13, XBDC14, XBDC15, XBDC16, XBDC17,
                XBDC18, XBDC19, XBDC20, XBDC21, XBDC22, XBDC23,
                XBDC24, XBDC25, XBDC26, XBDC27, XBDC28, XBDC29,
                XBDC30, XBDC31, XBDC32, XBDC33, XBDC34, XBDC35,
                XBDC36, XBDC37, XBDC38, XBDC39, XBDC40, XBDC41,
                XBDC42, XBDC43, XBDC44, XBDC45, XBDC46, XBDC47,
                XBDC48, XBDC49);
    }
}
