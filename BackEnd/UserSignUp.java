public UserSignUp () {
    initComponents();
}

public void main() {
}
private void initComponents() {
}


private void jButton1ActionPerformed (java. awt. event. ActionEvent evt) {
    String FirstName = txtFirstName.getText();
    String LastName = txtLastName.getText();
    String Email = txtEmail.getText();
    String Password = txtPassword.getText();
    int DOBMonth = txtDOBMonth.getText();
    int DOBDay = txtDOBDay.getText();
    int DOBYear = txtDOBYear.getText();
    String Address = txtAddress.getText();
    String City = txtCity.getText();
    String State = txtState.getText();
    int ZipCode = txtZIPcode.getText();
    String CardNum = txtCardNum.getText();
    int CVC = txtCVC.getText();
    String ExpDate = txtExpDate.getText();

 //Read and write to file
    public static void appendToFile(String filename, String content) {
        Path path = Paths.get("UserSignup.txt", true);

        try {
            if (ReadFile.Compare(content) != true) {
                content = content + "\n", "+FirstName+", "+LastName+", "+Email+", "+Password+", "+DOBMonth+", "+DOBDay+", "+DOBYear+", "+Address+", "+City+", "+State+", "+ZipCode+", "+CardNum+", "+CVC+", "+ExpDate+";
                Files.write(path, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                System.out.println("Successfully wrote to the file.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

    }
}
