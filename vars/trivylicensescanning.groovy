import org.generic.TrivyInstaller as TrivyInstallerImpl

def call(String repoUrl = '') {
    // Instantiate and return the shared library function from src
    new TrivyInstallerImpl().installTrivy(repoUrl)
}
