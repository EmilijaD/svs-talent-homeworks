package ifGodBless;

public interface MemberUpdateDelete {

	public void delete(String memberEmail);

	public void update( String oldEmail, String newName,
			String newEmail);
}
