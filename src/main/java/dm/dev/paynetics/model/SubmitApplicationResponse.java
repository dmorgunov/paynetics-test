package dm.dev.paynetics.model;

import lombok.Data;

import java.util.List;

@Data
public class SubmitApplicationResponse{
	Integer code;
	Data data;

	@lombok.Data
	public static class Data{
		Company company;
		String token;
	}

	@lombok.Data
	public static class Company{
		List<CompanyMembersItem> companyMembers;
		String token;
	}

	@lombok.Data
	public static class CompanyMembersItem{
		String lastName;
		String firstName;
		String token;
	}
}