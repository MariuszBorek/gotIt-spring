package com.gotit.entity;

import java.util.Objects;

public class Employee {
	private String empId;
	private String name;
	private String designation;
	private double salary;

	public Employee() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return Double.compare(employee.salary, salary) == 0 &&
				Objects.equals(empId, employee.empId) &&
				Objects.equals(name, employee.name) &&
				Objects.equals(designation, employee.designation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, name, designation, salary);
	}
}