import sys, gitlab, os, git, shutil, json, datetime, requests, subprocess, github

#initialize colorama
from colorama import init, Fore, Back, Style
init(autoreset=True)
#####################

def load_container_vars():
    container_path_repo = os.path.dirname(os.getcwd())
    container_path_repo_config = os.path.join(container_path_repo, '.config.json')
    return container_path_repo, container_path_repo_config

def load_gitlab_vars():
    gl_url = "https://gitlab.com"
    gl_username = input(Fore.CYAN +'Enter your GITLAB username: ')
    gl_token = input(Fore.CYAN +'Enter your GITLAB token: ')
    return gl_url, gl_username, gl_token

def load_github_vars():
    gh_url = "https://api.github.com/user/repos"
    gh_url_general = "https://github.com/"
    gh_url_remove = "https://api.github.com/repos/"
    gh_username = input(Fore.CYAN +'Enter your GITHUB username: ')
    gh_token = input(Fore.CYAN +'Enter your GITHUB token: ')
    return gh_url, gh_url_general, gh_url_remove, gh_username, gh_token

def prompt_repo_name():
    return input(Fore.CYAN +'Enter the repo name: ')

def create_config_file(config_path):
    with open(config_path, 'w') as data_file:
        json.dump({}, data_file, indent=4)

def open_config_data(config_path):
    try:
        with open(config_path, 'r') as data_file:
            return json.load(data_file)
    except FileNotFoundError:
        print(Fore.RED + f'[ERROR] {config_path} not found')

def get_gitConfig(config_key):
    command = ['git', 'config', '--get', config_key]
    result = subprocess.run(command, capture_output=True, text=True)
    if result.returncode == 0:
        return result.stdout.strip()
    else:
        return None

def add_data_to_config(key, value, config_path):
    data = open_config_data(config_path)
    #add to dictionary
    data[key] = value

    #add to json
    try:
        with open(config_path, 'w') as data_file:
            json.dump(data, data_file, indent=4)
    except IOError:
        print(Fore.RED + f'[ERROR] something went wrong in saving data on {config_path}')

def check_container_data(container_path_config):
    #open config file
    config_data = open_config_data(container_path_config)

    if all (key in config_data for key in ['EMAIL', 'GL_USERNAME', 'GL_TOKEN', 'GL_URL' ,'GH_USERNAME', 'GH_TOKEN', 'GH_URL', 'GH_URL_REMOVE']):
        print(Fore.GREEN + f'[SUCCESS - CHECK CONTAINER CONFIG] {container_path_config} loaded successfully')
        return True
    else:
        return False


def create_path(path, added):
    return os.path.join(path, added)

def create_local_repo(local_path):

    if local_path == "":
        local_path = os.path.dirname(os.path.abspath(__file__))
    try:
        os.mkdir(local_path)
        print(Fore.GREEN + f'[SUCCESS - LOCAL CREATED] {local_path} created successfully')
    except FileExistsError:
        print(Fore.RED + f'[ERROR] {local_path} already exists')

def remove_local(container_path, repo_name):
    local_path = create_path(container_path, repo_name)
    try:
        #check if local path repo exist
        if os.path.exists(local_path):
            #if none, remove it
            shutil.rmtree(local_path)
            print(Fore.GREEN + f'[SUCCESS - LOCAL DELETED] {local_path} has been deleted')
    except Exception as e:
        print(Fore.RED + f'[ERROR] {e}')

def open_gitlab_instance(container_path_config):
    #open container config
    data = open_config_data(container_path_config)
    #extract gitlab url
    gl_url = data['GL_URL']
    #extract gitlab token
    gl_token = data['GL_TOKEN']

    return gitlab.Gitlab(gl_url, private_token=gl_token)

def search_repo_exist(instance, repo_name):
    try:
        all_projects = instance.projects.list(search=repo_name, owned=True)
        return len(all_projects) > 0
    except gitlab.exceptions.GitlabGetError as e:
        print(Fore.RED + f'[ERROR] Gitlab API error: {e}')
        return False
def get_gitlab_id_repo(instance, repo_name, local_path_config):
    try:
        all_projects = instance.projects.list(search=repo_name, owned=True)
        for repo in all_projects:
            return repo.id
    except gitlab.exceptions.GitlabGetError as e:
        print(Fore.RED + f'[ERROR] Gitlab API error: {e}')

def set_visibility():
    visibility_prompt = input(Fore.CYAN +'Enter the repo visibility: (public/private)').lower()
    print(Fore.MAGENTA + f'[WARNING] press enter to set the repo visibility to "public"')

    if visibility_prompt == "" or visibility_prompt == "public" or visibility_prompt == "pub":
        return 'public'
    elif visibility_prompt == "private" or visibility_prompt == "pri":
        return 'private'
    else:
        return print(Fore.RED + f'[ERROR] {visibility_prompt} is not a valid option')
    

def create_gitlab_repo(container_path_config, repo_name, local_path_config, visibility):
    #open instance
    instance = open_gitlab_instance(container_path_config)
    #search if repo exist
    gl_repo_id = get_gitlab_id_repo(instance, repo_name, local_path_config)
    if gl_repo_id == None:
        #create repo
        gl_repo = instance.projects.create({'name': repo_name, 'visibility': visibility})
        #save repo url and repo id to local config
        add_data_to_config('GL_ID_REPO', gl_repo_id, local_path_config)
        add_data_to_config('GL_REPO_URL', gl_repo.http_url_to_repo, local_path_config)

        print(Fore.GREEN + f'[SUCCESS - GITLAB CREATED] {repo_name} created successfully')
        print(Fore.CYAN + f'[CHECK] Go to {gl_repo.http_url_to_repo} to check it!')
    else:
        print(Fore.RED + f'[ERROR] {repo_name} already exists')

def remove_gitlab(container_path, container_path_config, repo_name):
    
    #open instance
    instance = open_gitlab_instance(container_path_config)
    #create local paths
    local_path = create_path(container_path, repo_name)
    local_path_config = create_path(local_path, ".config.json")
    gl_id_repo = get_gitlab_id_repo(instance, repo_name, local_path_config)
    if  gl_id_repo != None:
        #remove gitlab repo
        instance.projects.delete(gl_id_repo)
        print(Fore.GREEN + f'[SUCCESS - GITLAB DELETED] {repo_name} in GITLAB has been deleted')
    else:
        print(Fore.RED + f'[ERROR] {repo_name} not found')


def create_github_repo(gh_remove_url, gh_url, gh_url_general, gh_token, gh_username, repo_name, visibility, local_path_config):
    #build the API url to create repo
    gh_project_url = gh_remove_url + gh_username + '/' + repo_name
    gh_repo_url = gh_url_general + gh_username + '/' + repo_name
    headers = {
        "Authorization": f"Bearer {gh_token}",
        "Accept": "application/vnd.github.v3+json"
    }
    data = {
        "name": repo_name,
        "private": False if visibility == "public" else True
    }
    response = requests.post(gh_url, headers=headers, json=data)
    if response.status_code == 201:
        add_data_to_config('GH_PROJECT_URL', gh_project_url, local_path_config)
        add_data_to_config('GH_REPO_URL', gh_repo_url, local_path_config)
        print(Fore.GREEN + f'[SUCCESS - GITHUB CREATED] {repo_name} created successfully')
        print(Fore.CYAN + f'[CHECK] Go to {gh_project_url} to check it!')
    else:
        print(Fore.RED + f'[ERROR] {gh_project_url} failed to create Github repository')
        print(Fore.RED + f'[ERROR] response {response.json()}')

def remove_github(repo_name, container_path, container_path_config):
    #create local paths, it is redundant but necessary for use local paths
    #TODO: think of another way to obtain local path

    local_path = create_path(container_path, repo_name)
    local_path_config = create_path(local_path, ".config.json")
    

    #obtain vars
    gh_project_url = open_config_data(local_path_config)['GH_PROJECT_URL']
    gh_token = open_config_data(container_path_config)['GH_TOKEN']
    gh_remove_url = open_config_data(container_path_config)['GH_URL_REMOVE']
    gh_username = open_config_data(container_path_config)['GH_USERNAME']

    #set header
    headers = {
        "Authorization": f"Token {gh_token}"
    }
    
    if gh_project_url == "":
        #build the api url to remove repo
        gh_project_url = gh_remove_url + gh_username + '/' + repo_name
    #send the DELETE request
    response = requests.delete(gh_project_url, headers=headers)

    #check response
    if response.status_code == 204:
        print(Fore.GREEN + f'[SUCCESS - GITHUB DELETE] {gh_project_url} deleted successfully')
    else:
        print(Fore.RED + f'[ERROR] {gh_project_url} failed to delete Github repository')
        print(Fore.RED + f'[ERROR] response {response.json()}')

def createReadme(local_path, local_path_config, repo_name):
    try:
        readme_path = local_path + '/README.md'
        add_data_to_config('README_PATH', readme_path, local_path_config)

        #create file
        with open(readme_path, 'w') as data_file:
            data_file.write('# ' + repo_name.upper())
        print(Fore.GREEN + f'[SUCCESS - README CREATED] {readme_path} created successfully')
        return readme_path
    except IOError as e:
        print(Fore.RED + f'[ERROR] {e}')

def gitCommit(local_path, readme_path):
    commitMessage = "[COMMIT AUTO GENERATED BY GITREPOS]"
    try:
        #git init on current directory
        repo = git.Repo(local_path)
        #add readme to stagging 
        repo.index.add(readme_path)
        #execute commit
        repo.index.commit(commitMessage)

        print(Fore.GREEN + f'[SUCCESS - README COMMITED] {readme_path} commited successfully')
    except Exception as e:
        print(Fore.RED + f'[ERROR] GIT COMMIT Failed to perform Git operation {e}')

def push_with_upstream(gitlabRepo, defaultBranch, gl_repo_url):
    # Obtener el repositorio remoto (usualmente con nombre 'origin')
    #origin = gitlabRepo.remote('main')
    #add remote repo
    origin = gitlabRepo.create_remote('origin', gl_repo_url)
    try:
        # Ejecutar el comando de push con --set-upstream
        origin.push(refspec=f"{defaultBranch}:{defaultBranch}", set_upstream=True)

        print(Fore.GREEN + f"[SUCCESS - README PUSHED] Push with upstream {defaultBranch}")
    except git.exc.GitCommandError as e:
        print(Fore.RED + f"[ERROR] Git push failed: {e}")

def set_up_gitlab_github_mirror(gitlabRepo, container_path_config):
    try:
            
        #obtain vars
        local_path = create_path(container_path, repo_name)
        local_path_config = create_path(local_path, ".config.json")
        gl_repo_url = open_config_data(local_path_config)['GL_REPO_URL']
        gh_repo_url = open_config_data(local_path_config)['GH_REPO_URL']
        gh_token = open_config_data(container_path_config)['GH_TOKEN']

        #add github repo to remote
        gitlabRepo.create_remote('github', gh_repo_url)

        #configure gitlab mirror
        gitlabRepo.git.remote('set-url', '--push', 'github', gh_repo_url)
        gitlabRepo.git.remote('set-url', '--push', '--add', 'github', gl_repo_url)
        #gitlabRepo.git.config('remote.github.mirror', 'true')

        #sync changes
        default_branch = gitlabRepo.active_branch.name
        #github_remote = gitlabRepo.remote('github')
        gitlabRepo.remotes.origin.pull(default_branch)
        #github_remote.push(default_branch)
        gitlabRepo.git.push('--all', 'github', **{'o': f'oauth2accesstoken:{gh_token}'})
        print(Fore.GREEN + f'[SUCCESS - MIRROR SET UP] {gh_repo_url} set up successfully')
    except Exception as e:
        print(Fore.RED + f'[ERROR] while setting up mirror {e}')

def initRepo():
    #obtain vars
    local_path = create_path(container_path, repo_name)
    local_path_config = create_path(local_path, ".config.json")
    gl_repo_url = open_config_data(local_path_config)['GL_REPO_URL']

    #open local repo
    gitlabRepo = git.Repo.init(local_path)
    #obtain repo active branch
    defaultBranch = gitlabRepo.active_branch.name
    add_data_to_config('DEFAULT_BRANCH', defaultBranch, local_path_config)
    
    readme_path = createReadme(local_path, local_path_config, repo_name)
    gitCommit(local_path, readme_path)
    push_with_upstream(gitlabRepo, defaultBranch, gl_repo_url)
    set_up_gitlab_github_mirror(gitlabRepo, container_path_config)

def create_container(container_path_config):
    if os.path.exists(container_path_config):
        if check_container_data(container_path_config) == False:
            #it is neccesary {} structure in json file, if not declared wil be failed

            #prompt container vars
            gl_url, gl_username, gl_token = load_gitlab_vars()
            gh_url, gh_url_general, gh_url_remove, gh_username, gh_token = load_github_vars()

            #save container vars
            add_data_to_config('EMAIL', get_gitConfig("user.email"), container_path_config)
            add_data_to_config('GL_USERNAME', gl_username, container_path_config)
            add_data_to_config('GL_TOKEN', gl_token, container_path_config)
            add_data_to_config('GL_URL', gl_url, container_path_config)
            add_data_to_config('GH_USERNAME', gh_username, container_path_config)
            add_data_to_config('GH_TOKEN', gh_token, container_path_config)
            add_data_to_config('GH_URL', gh_url, container_path_config)
            add_data_to_config('GH_URL_GENERAL', gh_url_general, container_path_config)
            add_data_to_config('GH_URL_REMOVE', gh_url_remove, container_path_config)

            print(Fore.GREEN + f'[SUCCESS - CONTAINER CREATED] {container_path_config} saved successfully')
    else:
        print(Fore.RED + '[ERROR] config file not found')

def create_local(container_path, repo_name):
    #join paths and obtain local path
    local_path = create_path(container_path, repo_name)
    #create directory local for repo
    create_local_repo(local_path)

    #joins path and obtain local path config
    local_path_config = create_path(local_path, ".config.json")
    #create repo's config file
    create_config_file(local_path_config)
    #add data to config
    add_data_to_config('LOCAL_PATH', local_path, local_path_config)
    add_data_to_config('LOCAL_PATH_CONFIG', local_path_config, local_path_config)

def create_gitlab(container_path, container_path_config, repo_name):
    #create local paths, it is redundant but necessary for use local paths
    #TODO: think of another way to obtain local path

    local_path = create_path(container_path, repo_name)
    local_path_config = create_path(local_path, ".config.json")

    #prompt repo visibility
    visibility = set_visibility()
    #save visibility on local config
    add_data_to_config('GL_VISIBILITY', visibility, local_path_config)

    create_gitlab_repo(container_path_config, repo_name, local_path_config, visibility)

def create_github(container_path, container_path_config, repo_name):
    #create local paths, it is redundant but necessary for use local paths
    local_path = create_path(container_path, repo_name)
    local_path_config = create_path(local_path, ".config.json")

    #obtain gh token
    gh_token = open_config_data(container_path_config)['GH_TOKEN']

    #obtain gh username
    gh_username = open_config_data(container_path_config)['GH_USERNAME']

    #obtain gh urls
    url_gh = open_config_data(container_path_config)['GH_URL']
    gh_url_general = open_config_data(container_path_config)['GH_URL_GENERAL']
    url_remove_gh = open_config_data(container_path_config)['GH_URL_REMOVE']

    #prompt repo visibility
    visibility = set_visibility()
    #save visibility on local config
    add_data_to_config('GH_VISIBILITY', visibility, local_path_config)

    create_github_repo(url_remove_gh, url_gh, gh_url_general, gh_token, gh_username, repo_name, visibility, local_path_config)

if __name__ == '__main__':
    
    main_prompt = input(Fore.CYAN +'Do you want remove or create new repo? r/c: ').lower()

    #prompt repo name
    repo_name = prompt_repo_name()

    #load container paths
    container_path, container_path_config =  load_container_vars()

    if main_prompt == 'c':
    #     #create container
        create_container(container_path_config)
    #     #create local
        create_local(container_path, repo_name)
    #     #create gitlab
        create_gitlab(container_path, container_path_config, repo_name)
    #     #create github
        create_github(container_path, container_path_config, repo_name)
    #   init repo from git
        initRepo()
    elif main_prompt == 'r':
        remove_prompt = input('Are you sure you want to delete the repository? y/n: ').lower()
        if remove_prompt == "y":
        #   remove github repo
            remove_github(repo_name, container_path, container_path_config)
        #   remove gitlab repo
            remove_gitlab(container_path, container_path_config, repo_name)
        #   remove local
            remove_local(container_path, repo_name)
        else:
            print(Fore.RED + '[YOU ARE SAVED] YOU COULD HAVE MESSED IT UP, CARAPAN')
    else:
        print (Fore.RED + '[ERROR] wrong option wont be existed')

    