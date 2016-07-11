package beans;

import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class Employee {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		try {
			CachedRowSet crs = new OracleCachedRowSet();
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setCommand("select * from employees where employee_id = ?");
			crs.setInt(1, id);
			crs.execute();
			crs.next();
			name = crs.getString("first_name") + " " + crs.getString("last_name");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			name = null;
		}

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
