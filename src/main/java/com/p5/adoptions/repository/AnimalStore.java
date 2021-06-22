package com.p5.adoptions.repository;

import com.p5.adoptions.services.model.AnimalDomain;
import com.p5.adoptions.services.model.CatDomain;
import com.p5.adoptions.services.model.DogDomain;

import java.util.ArrayList;
import java.util.List;

public class AnimalStore {

    public static final List<AnimalDomain> available = new ArrayList<AnimalDomain>() {{

        add(new DogDomain(1,"Alfi", "https://www.google.com/search?q=dog&rlz=1C1CHBD_enRO871RO871&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjipuTz8cbwAhU6gP0HHSQyDaEQ_AUoAXoECAEQAw&biw=1745&bih=852#imgrc=KypVIfrnXZbYeM"));
        add(new DogDomain(2,"Brien", "https://www.google.com/search?q=dog&rlz=1C1CHBD_enRO871RO871&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjipuTz8cbwAhU6gP0HHSQyDaEQ_AUoAXoECAEQAw&biw=1745&bih=852#imgrc=Oq4aPNXzNnLCEM"));
        add(new DogDomain(3, "Mark", "https://www.google.com/search?q=dog&rlz=1C1CHBD_enRO871RO871&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjipuTz8cbwAhU6gP0HHSQyDaEQ_AUoAXoECAEQAw&biw=1745&bih=852#imgrc=iTgehSx7lrAsdM"));
        add(new CatDomain(1, "Kiki", "https://www.google.com/search?q=cat&tbm=isch&ved=2ahUKEwiy1-n-8cbwAhW07LsIHRVWACsQ2-cCegQIABAA&oq=cat&gs_lcp=CgNpbWcQAzIHCAAQsQMQQzIECAAQQzIECAAQQzIECAAQQzIECAAQQzIECAAQQzIFCAAQsQMyBQgAELEDMgQIABBDMgQIABBDUPuXBVimmwVg86AFaABwAHgAgAF-iAHuApIBAzAuM5gBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=oDqdYLKHOrTZ7_UPlayB2AI&bih=852&biw=1745&rlz=1C1CHBD_enRO871RO871#imgrc=0V922RrJgQc9SM"));
        add(new CatDomain(2, "Riki", "https://www.google.com/search?q=cat&tbm=isch&ved=2ahUKEwiy1-n-8cbwAhW07LsIHRVWACsQ2-cCegQIABAA&oq=cat&gs_lcp=CgNpbWcQAzIHCAAQsQMQQzIECAAQQzIECAAQQzIECAAQQzIECAAQQzIECAAQQzIFCAAQsQMyBQgAELEDMgQIABBDMgQIABBDUPuXBVimmwVg86AFaABwAHgAgAF-iAHuApIBAzAuM5gBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=oDqdYLKHOrTZ7_UPlayB2AI&bih=852&biw=1745&rlz=1C1CHBD_enRO871RO871#imgrc=92QxTb8XPrhGhM"));
        add(new CatDomain(3,"Miki", "https://www.google.com/search?q=cat&tbm=isch&ved=2ahUKEwiy1-n-8cbwAhW07LsIHRVWACsQ2-cCegQIABAA&oq=cat&gs_lcp=CgNpbWcQAzIHCAAQsQMQQzIECAAQQzIECAAQQzIECAAQQzIECAAQQzIECAAQQzIFCAAQsQMyBQgAELEDMgQIABBDMgQIABBDUPuXBVimmwVg86AFaABwAHgAgAF-iAHuApIBAzAuM5gBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=oDqdYLKHOrTZ7_UPlayB2AI&bih=852&biw=1745&rlz=1C1CHBD_enRO871RO871#imgrc=ICe62_JkBNhtQM"));

    }};
}
