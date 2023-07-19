package dm.dev.paynetics.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmitApplicationRequest {
    List<PayoutDetailsItem> payoutDetails;
    Questionnaire questionnaire;
    Acquiring acquiring;
    String fingerprint;
    String merchant;
    Company company;
    String ipAddress;
    List<ProductsItem> products;
    String dueDiligence;

    @Data
    public static class Acquiring {
        Pos pos;
        Ecommerce ecommerce;
    }

    @Data
    public static class TypeItem {
        String type;
        List<String> jsonMemberEnum;
    }

    @Data
    public static class Questionnaire {
        Boolean makeBusinessWithSan;
        Boolean performTransactionsOnBehalfOfClients;
        Boolean hasOffshoreClients;
        Boolean requireAdditionalLicenses;
        Boolean purposeOfUsage;
        Boolean hasKycProcedure;
        Boolean maintainsAccountsOnBehalfOfClients;
        Boolean isOffShore;
        Boolean hasKycProcedureDescription;
        Boolean isOnline;
        String sourceOfFunds;
        Integer monthsOfDoingBusiness;
        Integer projectedMonthlyVolume;
    }

    @Data
    public static class Pos {
        String feeGroup;
        String descriptor;
        String projectedMonthlyValue;
    }

    @Data
    public static class CompanyMembersItem {
        String birthday;
        String country;
        Boolean pepDeclaration;
        String uniqueIdentifier;
        String countryOfResidence;
        String city;
        List<DocumentsItem> documents;
        String county;
        List<TypeItem> type;
        String legalForm;
        String uic;
        String contactEmail;
        String mobilePhone;
        String legalName;
        String firstName;
        String zip;
        String address2;
        String address1;
        String lastName;
        Boolean pepRelatedDeclaration;
        Boolean isSip;
        String placeOfBirth;
        Boolean ownership;
        String nationality;
        String phone;
        String user;
        Integer ownershipPercentage;
    }

    @Data
    public static class PayoutDetailsItem {
        String accountNumber;
        String amount;
        String period;
        String delay;
        String iban;
        String currency;
        String sortCode;
    }

    @Data
    public static class Company {
        String country;
        String city;
        String countryOfIncorporation;
        List<DocumentsItem> documents;
        String county;
        String mcc;
        String legalForm;
        String vatRegistration;
        String uic;
        String tradeName;
        String contactEmail;
        Boolean isSie;
        String mobilePhone;
        String legalName;
        String incorporationDate;
        String zip;
        String correspondenceAddress;
        String website;
        List<CompanyMembersItem> companyMembers;
        String address2;
        String address1;
        String businessActivity;
        String legalFormDescription;
        String phone;
        String descriptionOfActivity;
        String addressOfShop;
    }

    @Data
    public static class Ecommerce {
        List<SupportedAuthorizationTypesItem> supportedAuthorizationTypes;
        String register3ds;
        String feeGroup;
        String descriptor;
        String projectedMonthlyValue;
    }

    @Data
    public static class DocumentsItem {
        String file;
        String fileType;
        String documentType;
    }

    @Data
    public static class SupportedAuthorizationTypesItem {
        String type;
        List<String> jsonMemberEnum;
    }

    @Data
    public static class ProductsItem {
        String type;
        List<String> jsonMemberEnum;
    }
}