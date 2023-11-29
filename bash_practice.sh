#!/bin/bash

# create user groups
addgroup dev
addgroup user
addgroup ops

# notify the user about the group creation
echo "Groups 'dev', 'user', and 'ops' created successfully."

# create users and assign them to groups
for i in {1..10}; do
    username="user$i"
    password="password$i"

    useradd -m -s /bin/bash $username
    echo "$username:$password" | chpasswd

    groups=("dev" "user" "ops")
    random_group=${groups[$((RANDOM % ${#groups[@]}))]}
    usermod -aG $random_group $username

    echo "User $username created with password $password and added to group $random_group"
done

# confirm that groups are non-empty
echo "Members of dev group: $(getent group dev | cut -d: -f4)"
echo "Members of user group: $(getent group user | cut -d: -f4)"
echo "Members of ops group: $(getent group ops | cut -d: -f4)"

# create 3 main directories
mkdir -p directory1 directory2 directory3

# function to create random subdirectories and files
create_random_structure() {
    local directory="$1"
    local num_subdirectories=$((RANDOM % 4 + 2))  # Random number of subdirectories (2 to 5)
    local num_files=$((RANDOM % 6 + 5))           # Random number of files (5 to 10)

    for i in $(seq "$num_subdirectories"); do
        subdirectory="$directory/subdirectory$i"
        mkdir -p "$subdirectory"

        for j in $(seq "$num_files"); do
            touch "$subdirectory/file$j.txt"
        done
    done
}

# create random structure in each main directory
create_random_structure "directory1"
create_random_structure "directory2"
create_random_structure "directory3"

echo "Random directory structure created."

# grant read-only access to the first directory for the user group
chgrp user directory1
chmod g-x directory1
# grant read and write access to the second directory for the dev group
chgrp dev directory2
chmod g-x+w directory2
# read and execute set by default
chgrp ops directory3

echo "Permissions to groups were granted"

# Collect output into a file with timestamp
timestamp=$(date +"%Y%m%d%H%M%S")
output_file="results_$timestamp.txt"

{
    echo "Files inside directory1 with permissions:"
    find directory1 -type f -exec stat --format="%A %G %U %n" {} \;

    echo -e "\nFiles inside directory2 with permissions:"
    find directory2 -type f -exec stat --format="%A %G %U %n" {} \;

    echo -e "\nFiles inside directory3 with permissions:"
    find directory3 -type f -exec stat --format="%A %G %U %n" {} \;
} > "$output_file"

echo "Output collected into $output_file"

# delete users
for i in {1..10}; do
    username="user$i"
    userdel -r $username
    echo "User $username deleted"
done

# remove user groups
delgroup dev
delgroup user
delgroup ops

echo "User groups deleted."
