package utils;

public class EmployeeProperties {

    private static final PropertiesReader propertiesReader = new PropertiesReader();

    private static final String employeeHost = propertiesReader.getHost();

    public static final String getEmployeesURL = String.format("%s/api/v1/employees",employeeHost);
    public static final String getEmployeeByIdURL = String.format("%s/api/v1/employee/",employeeHost);
    public static final String createEmployeeURL = String.format("%s/api/v1/create",employeeHost);
    public static final String updateEmployeeURL = String.format("%s/api/v1/update/",employeeHost);
    public static final String deleteEmployeeURL = String.format("%s/api/v1/delete/",employeeHost);
}
