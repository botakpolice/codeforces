#!/bin/bash

# Path to test files
FILE=$1
TEST_DIR=$2

# Compile your Java code (if needed)
javac "$FILE".java || { echo "Compilation failed"; exit 1; }

# Create output directory
mkdir -p outputs

# Loop all .in files
for input_file in "$TEST_DIR"/*.in; do
    # Extract the base name (e.g., 001-small)
    base=$(basename "$input_file" .in)

    ans_file="$TEST_DIR/$base.ans"
    out_file="outputs/$base.out"

    echo "Running test: $base"

    # Run your Java program
    java Solution < "$input_file" > "$out_file"

    # Compare the result
    if diff -q "$out_file" "$ans_file" > /dev/null; then
        echo "PASS  $base"
    else
        echo "FAIL  $base"
        echo "Differences:"
        diff "$out_file" "$ans_file"
    fi

    echo "------------------------"
done
