package gestion_listes_courses.bo;

public class Item {
	
	//--------------------------------------------------------------------------
	// Attributes
	//--------------------------------------------------------------------------
	private int id;
	private String name;
	private boolean checked;

	//--------------------------------------------------------------------------
	// Constructors
	//--------------------------------------------------------------------------
	public Item() {
		super();
	}
	public Item(int id, String name, boolean checked) {
		super();
		this.id = id;
		this.name = name;
		this.checked = checked;
	}
	public Item(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Item(String name) {
		super();
		this.name = name;
	}
	
	//--------------------------------------------------------------------------
	// Getters
	//--------------------------------------------------------------------------
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public boolean isChecked() {
		return this.checked;
	}

	//--------------------------------------------------------------------------
	// Setters
	//--------------------------------------------------------------------------
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	//--------------------------------------------------------------------------
	// toString
	//--------------------------------------------------------------------------
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", checked=" + checked + "]";
	}

		
}
