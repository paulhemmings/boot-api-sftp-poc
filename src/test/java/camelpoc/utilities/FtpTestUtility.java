package camelpoc.utilities;

import org.mockftpserver.fake.FakeFtpServer;
import org.mockftpserver.fake.UserAccount;
import org.mockftpserver.fake.filesystem.FileSystem;
import org.mockftpserver.fake.filesystem.UnixFakeFileSystem;

public class FtpTestUtility {

  private FakeFtpServer fakeFtpServer;

  public void setUp() {
    try {
      fakeFtpServer = new FakeFtpServer();
      fakeFtpServer.setServerControlPort(21);

      FileSystem fileSystem = new UnixFakeFileSystem();
      fakeFtpServer.setFileSystem(fileSystem);

      UserAccount userAccount = new UserAccount("bob", "123", "./content/output");
      fakeFtpServer.addUserAccount(userAccount);
      fakeFtpServer.start();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void tearDown() throws Exception {
    fakeFtpServer.stop();
  }

}
