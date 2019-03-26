/**
 * Copyright(C) 2019 xstgongyi.org
 * All rights reserved
 */
package org.xstgongyi.eduaid.masterdata.dataobject;

import java.time.LocalDateTime;

/**
 * @author oldcrane
 * @created 2019-03-25
 */
public class SchoolYearDO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String active; // Y-active, N-inactive
	private LocalDateTime gmtCreated;
	private LocalDateTime gmtUpdated;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public LocalDateTime getGmtCreated() {
		return gmtCreated;
	}

	public void setGmtCreated(LocalDateTime gmtCreated) {
		this.gmtCreated = gmtCreated;
	}

	public LocalDateTime getGmtUpdated() {
		return gmtUpdated;
	}

	public void setGmtUpdated(LocalDateTime gmtUpdated) {
		this.gmtUpdated = gmtUpdated;
	}

	@Override
	public String toString() {
		return "SchoolYearDO[id=" + id + ", name=" + name + ", active=" + active + "]";
	}

}
