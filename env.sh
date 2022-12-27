#!/bin/bash
# Read and parse environment variables to json.
#--------------------------------------------------------------
# Credentials file. TODO: Implement dynamic file input.
file="XCP_Credentials.env"
# Set '=' as delimiter to separate the string. 
IFS='=' 

while read -r line; do
    #Read the split words into an array based on the IFS.
    #the option '-r' is used to define that backslash (\) 
    #is a character rather than escape character. 
    #The '-a' option is used to define that the words 
    #(separated by $IFS) are assigned to the sequential index 
    #of array beginning at zero.

    read -ra strarr <<< "$line"
    cat <<EOF
    ${for word in "${strarr[@]}"; do
        printf "$word\n"
    done}
    EOF
    # echo -e "$line\n"
done <$file 
#--------------------------------------------------------------