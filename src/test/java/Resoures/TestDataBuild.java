package Resoures;

import java.util.ArrayList;
import java.util.List;
import pojo.Addplace;
import pojo.location;

public class TestDataBuild {

	public Addplace AddplacePayload() {

		Addplace p = new Addplace();
		p.setAccuracy(50);
		p.setLanguage("French-IN");
		p.setAddress("29, side layout, cohen 09");
		p.setName("Frontline house");
		p.setPhone_number("(+91) 983 893 3937");
		location l = new location();

		l.setLng("-38.383494");
		l.setLng("33.427362");
		p.setLocation(l);

		List<String> mylist = new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		p.setTypes(mylist);
		return p;

	}
}
