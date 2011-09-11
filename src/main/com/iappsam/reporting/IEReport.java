package com.iappsam.reporting;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRVariable;

import com.iappsam.forms.IE;
import com.iappsam.forms.IELine;

public class IEReport extends AbstractReport {

	private IE form;

	public IEReport(IE form) throws ReportException {
		super("ie");
		setForm(form);
	}

	private void setForm(IE form) throws ReportException {
		this.form = form;
		initPropertyMap();
		fillReport();
	}

	@Override
	protected List<Object[]> getRows() {
		List<Object[]> objs = new ArrayList<Object[]>();

		for (IELine line : form.getLines())
			objs.add(line.toArrayObject());

		return objs;
	}

	@Override
	protected String[] getColumnTitles() {
		return new String[] { "Property Number", "EQUIPMENT PROPERTY", "ARTICLE CODE", "QUANTITY", "UNIT VALUE", "TOTAL VALUE", "YEAR Acquired",
				"HOW ACQUIRED", "PRESENT CONDITION", "PERSON ACCOUNTABLE", "REMARKS" };
	}

	@Override
	protected void initPropertyMap() {
		propertyMap.put("Unit", form.getDivisionOffice() + "");
		propertyMap.put("Prepared by NAME", form.getPreparedBy().getPerson().getName());
		propertyMap.put("Date Prepared", form.getDatePrepared() + "");
		propertyMap.put("BUILDING", form.getBuilding() + "");
		propertyMap.put("Prepared by DESIGNATION", form.getPreparedBy().getDesignation());
		propertyMap.put("MEMBER_NAME", form.getCommitteeMember1().getPerson().getName());
		propertyMap.put("MEMBER_DESIGNATION", form.getCommitteeMember1().getDesignation());
		propertyMap.put("MEMBER2_NAME", form.getCommitteeMember2().getPerson().getName());
		propertyMap.put("MEMBER2_DESIGNATION", form.getCommitteeMember2().getDesignation());
		propertyMap.put("COUNTER_CHECK_NAME", form.getCounterCheckedBy().getPerson().getName());
		propertyMap.put("COUNTER_CHECK_DESIGNATION", form.getCounterCheckedBy().getDesignation());
		propertyMap.put("NOTED_NAME", form.getNotedBy().getPerson().getName());
		propertyMap.put("NOTED_DESIGNATION", form.getNotedBy().getDesignation());
		propertyMap.put("COA_NAME", form.getCoaRepresentative().getPerson().getName());
		propertyMap.put("COA_DESIGNATION", form.getCoaRepresentative().getDesignation());
	}
}
