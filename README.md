<div align="center">
  <img src="./img/gitrepos_bck.png" alt="tabla de los tipos de datos" style="width:100vw; height:40vh;">
</div>

## What is GITREPOS

GITREPOS es un script en Python que facilita la automatización de tareas relacionadas con la creación y eliminación de repositorios en GitHub y GitLab. Además, proporciona la funcionalidad para conectar estos repositorios en un "mirror", lo que permite que los cambios realizados en uno de los repositorios se reflejen automáticamente en el otro.

## What is in GITREPOS repository

- **gitrepos.py**: This is the main script what create and configurate or remove the repositories.
- **gitPushMirror.sh**: This script is only for run `git push` command on both repositories.
- **requirements.txt**: This file contain all necessary packages for run gitrepos
- **container.config.json**: This file is an example of how your .config.json (container) will look like
- **local.config.json**: This file is an example of how your .config.json (local dir repository) will look like

## How to run

:warning: **You must be installed Python 2.5 or newer and GIT 2.39 or newer on your local system** :warning:

### 1. First of all, you must create a container directory where all repositories will be stored

Ex: my container configuration

- gitlab (container)
  - gitrepos (repo1)
  - personalRepo (repo2)
  - otherRepos (repo3)

### 2. Download or clone this repository

- Download the script: `wget https://gitlab.com/Nuria_Liano/gitrepos/-/raw/main/gitrepos.py?inline=false`
- Clone the repository
  - SSH  `git clone git@gitlab.com:Nuria_Liano/gitrepos.git`
  - HTTPS  `git clone https://gitlab.com/Nuria_Liano/gitrepos.git`

### 3. Install all requirements

- Python 2.5 `pip -r requirements.txt`
- Python 3 `pip3 -r requirements.txt`

### 4. Execute script

- Python 2.5 `python gitrepos.py`
- Python 3 `python3 gitrepos.py`

### 5. Now you can use that repository and you can execute `git add` and `git commit -m ""` normally

### 6. :warning: But when you execute git push it is neccesary you run the gitPushMirror.sh

   ~~~sh
   sh gitPushMirror.sh
   ~~~

## What data I need

The first time you run the script it will ask for all the variables it does not find and generate the `.config.json` file both in the container and locally.

### Gitlab data

- **Username**: "Nuria_Liano"
- **Gitlab Token**: "asa7f9sd87fsg8sd987sd8g8s"

### Github data

- **Username**: "NuriaLiano"
- **Github Token**: "asa7f9sd87fsg8sd987sd8g8s"
  
## How generate mirror

The `set_up_gitlab_github_mirror` function is responsible for setting up a mirror between a GitLab repository and a GitHub repository. Here's the step-by-step of how it does this setup:

- **Gets the necessary variables**: the function starts by getting the paths to the directories and files needed for the mirror setup. It uses the create_path function to create the paths to the local directories and the configuration file local_path_config. In addition, it gets the URLs of the GitLab and GitHub repositories, as well as the GitHub access token, from the container_path_config configuration file.
- **Add the GitHub repository as a remote**: Use the gitpython library to add the GitHub repository as a remote named "github" to the local GitLab repository. This is accomplished with the line gitlabRepo.create_remote('github', gh_repo_url). This way, the local GitLab repository is configured to push changes to the GitHub repository via the remote "github".
- **Configure the mirror in GitLab**: Use the Git command line tool to configure the mirror between the GitLab repository and the GitHub repository. This is done through the following lines of code:

    ~~~py
    gitlabRepo.git.remote('set-url', '--push', 'github', gh_repo_url)
    gitlabRepo.git.remote('set-url', '--push', '--add', 'github', gl_repo_url)
    ~~~

    These lines set the push URLs for the remote "github" so that changes made to the local GitLab repository are automatically pushed to the GitHub repository. gh_repo_url represents the URL of the GitHub repository and gl_repo_url represents the URL of the GitLab repository.
- **Synchronise changes**: The function gets the name of the active branch in the local GitLab repository by default_branch = gitlabRepo.active_branch.name. It then performs a pull operation from the GitLab repository to get the most recent changes to the active branch, using the line gitlabRepo.remotes.origin.pull(default_branch). It then performs a push operation on the "github" remote to push the changes to the GitHub repository, using the GitHub access token for authentication:

    ~~~py
    gitlabRepo.git.push('--all', 'github', **{'o': f'oauth2accesstoken:{gh_token}'})
    ~~~

## Errors and suggestions

If you find a problem with the code or have implemented an improvement please open an issue.

## License

All content in this repository is licensed under a [Creative Commons Attribution-NonCommercial 4.0 International Public License](./LICENSE)

## Contact

You can write to me at <hola@nurialiano.es>

Visit my profiles or my website

<div>
    <p align="center">
        <a href="https://www.twitch.tv/nurialiano" target="_blank"><img height="50" src="https://gitlab.com/Nuria_Liano/nurialiano/-/raw/main/icons/twitch.svg" /></a>
        <a href="https://gitlab.com/nuria_liano" target="_blank"><img height="50" src="https://gitlab.com/Nuria_Liano/nurialiano/-/raw/main/icons/gitlab.svg" /></a>
        <a href="https://github.com/nurialiano" target="_blank"><img height="50" src="https://gitlab.com/Nuria_Liano/nurialiano/-/raw/main/icons/github.svg" /></a>
        <a href="https://twitter.com/nuria_liano" target="_blank"><img height="50" src="https://gitlab.com/Nuria_Liano/nurialiano/-/raw/main/icons/twitter.svg"  /></a>
        <a href="https://www.buymeacoffee.com/nurialiano" target="_blank"><img height="50" src="https://gitlab.com/Nuria_Liano/nurialiano/-/raw/main/icons/by-me-a-coffee.png" /></a>
        <a href="www.nurialiano.es" target="_blank"><img height="50" src="https://gitlab.com/Nuria_Liano/nurialiano/-/raw/main/icons/nl_logo.png"/></a>
    </p>
</div>

---

<div>
    <p align="center">Desarrollado en <a href="https://turismodecantabria.com/inicio"></a> <img src="./icons/cantabria.png" height="30" alt="Cantabria">  con mucho <img src="./icons/metal.png" height="30" alt="metal"> y <img src="./icons/beer.png" height="30" alt="cerveza"></p>
</div>
