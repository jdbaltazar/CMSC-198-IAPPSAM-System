package com.iappsam.servlet.app;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Item;
import com.iappsam.forms.APP;
import com.iappsam.forms.APPLine;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.ServletTestCase;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class APPParserTest extends ServletTestCase {

	@Before
	public void init() {
		super.init();
	}

	@Test
	public void requiredFields() throws TransactionException {
		givenParam("year", "2010");
		givenParam("division-office", "1");
		givenParam("plan-control-number", "11");
		givenParam("date", "2010-01-01");
		givenParam("prepared-by", "1");
		givenParam("recommended-by", "2");
		givenParams("items", new String[] { "1" });
		givenParams("q1", new String[] { "0" });
		givenParams("q2", new String[] { "1" });
		givenParams("q3", new String[] { "2" });
		givenParams("q4", new String[] { "3" });

		DivisionOffice doff = new DivisionOffice("division", "office");
		given(dom.getDivisionOffice(1)).willReturn(doff);

		Item item = Item.create("des", "Cat", "uni", "Stat", "coin");
		given(im.getItem(1)).willReturn(item);

		Employee preparedBy = Employee.create("des", "john");
		given(pm.getEmployee(1)).willReturn(preparedBy);
		Employee recommendedBy = Employee.create("dess", "maria");
		given(pm.getEmployee(2)).willReturn(recommendedBy);

		// APP f = (APP) new AppParser().createForm(request, appContext);
		//
		// assertEquals(2010, f.getYear());
		// assertEquals(doff, f.getDivisionOffice());
		// assertEquals("11", f.getPlanControlNumber());
		// assertEquals(Date.valueOf("2010-01-01"), f.getDateScheduled());
		// assertEquals(preparedBy, f.getPreparedBy());
		// assertEquals(recommendedBy, f.getRecommendedBy());
		//
		// APPLine line = f.getLines().toArray(new APPLine[1])[0];
		//
		// assertEquals(item, line.getItem());
		// assertEquals(0, line.getQuantityQuarter1());
		// assertEquals(1, line.getQuantityQuarter2());
		// assertEquals(2, line.getQuantityQuarter3());
		// assertEquals(3, line.getQuantityQuarter4());
	}
}
