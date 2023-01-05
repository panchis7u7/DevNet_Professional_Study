Copy the directory and rename it ".env"
asign the variables a value based on your resources.

To export all variables from the files, run:
```shell
source <path_env_file> && export $(sed '/^#/d' <path_env_file> | cut -d= -f1)
```