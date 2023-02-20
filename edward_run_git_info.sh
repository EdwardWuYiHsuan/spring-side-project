#!/bin/bash

project_name=$(pwd | sed 's/.*\/workspace\///g' | cut -f1 -d"/")
git_repository=$(git config --get remote.origin.url | sed 's/:/\//g' | sed 's/git@/https:\/\//g' | sed 's/\.git//g')
git_branch=$(git branch --show-current)
git_top_commit=$(git log -1 --pretty=format:%h)
git_commits=$(git log HEAD ^origin --author=Edward --pretty=format:"%ci %h" | sort | awk '{print $4}' | tr '\n' '、' | rev | cut -c2- |rev)

echo ============================
echo Project : ${project_name}
echo Repository : ${git_repository}
echo Branch : ${git_branch}
echo Top Commit : ${git_top_commit}
echo
echo ----------------------------
echo Project : ${project_name}
echo Branch : ${git_branch}
echo Commit : ${git_commits}
