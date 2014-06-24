package com.dianping.cat.report.page.network;

import com.dianping.cat.report.ReportPage;
import com.dianping.cat.report.page.AbstractReportPayload;

import org.unidal.web.mvc.ActionContext;
import org.unidal.web.mvc.payload.annotation.FieldMeta;

public class Payload extends AbstractReportPayload<Action> {
	private ReportPage m_page;

	@FieldMeta("op")
	private Action m_action;

	@FieldMeta("product")
	private String m_product;

	@FieldMeta("frequency")
	private int m_frequency = 10;

	@FieldMeta("refresh")
	private boolean m_refresh = false;

	@FieldMeta("timeRange")
	private int m_timeRange = 24;

	@FieldMeta("fullScreen")
	private boolean m_fullScreen = false;

	@FieldMeta("hideNav")
	private boolean m_hideNav = true;

	@FieldMeta("group")
	private String m_group;

	@FieldMeta("minute")
	private int m_minute = -1;

	public String getGroup() {
		return m_group;
	}

	public void setGroup(String group) {
		m_group = group;
	}

	public Payload() {
		super(ReportPage.NETWORK);
	}

	@Override
	public Action getAction() {
		return m_action;
	}

	public int getFrequency() {
		return m_frequency;
	}

	@Override
	public ReportPage getPage() {
		return m_page;
	}

	public String getProduct() {
		return m_product;
	}

	public int getTimeRange() {
		return m_timeRange;
	}

	public boolean isFullScreen() {
		return m_fullScreen;
	}

	public boolean isRefresh() {
		return m_refresh;
	}

	public void setAction(String action) {
		m_action = Action.getByName(action, Action.NETTOPOLOGY);
	}

	public void setFrequency(int frequency) {
		m_frequency = frequency;
	}

	public void setFullScreen(boolean fullScreen) {
		m_fullScreen = fullScreen;
	}

	@Override
	public void setPage(String page) {
		m_page = ReportPage.getByName(page, ReportPage.NETWORK);
	}

	public void setProduct(String product) {
		m_product = product;
	}

	public void setRefresh(boolean refresh) {
		m_refresh = refresh;
	}

	public boolean isHideNav() {
		return m_hideNav;
	}

	public void setHideNav(boolean hideNav) {
		m_hideNav = hideNav;
	}

	@Override
	public void validate(ActionContext<?> ctx) {
		if (m_action == null) {
			m_action = Action.NETTOPOLOGY;
		}
	}

	public int getMinute() {
		return m_minute;
	}

	public void setMinute(int minute) {
		m_minute = minute;
	}
	
}