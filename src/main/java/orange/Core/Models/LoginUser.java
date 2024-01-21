package orange.Core.Models;

public class LoginUser {
    public record UserModel(String email, String password) {

        public static UserModel loginUser() {
            return new LoginUser.UserModel("Admin","admin123");
        };
    }
}
