/**
 * Copyright(C) 2019 xstgongyi.org
 * All rights reserved
 */
package org.xstgongyi.eduaid.masterdata.dataobject;

import java.math.BigInteger;

/**
 * @author oldcrane
 * @created 2019-03-26
 */
public class SemesterDO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Integer status;
	private BigInteger schoolYearId;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigInteger getSchoolYearId() {
		return schoolYearId;
	}

	public void setSchoolYearId(BigInteger schoolYearId) {
		this.schoolYearId = schoolYearId;
	}

	@Override
	public String toString() {
		return "SemesterDO[id=" + id + ", name=" + name + ", status=" + status + ", schoolYearId=" + schoolYearId + "]";
	}

}
