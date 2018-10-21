# How to contribute

We would love your help in contributing to Neg5 stats API! 

## Getting Started

* Make sure you have a [GitHub account](https://github.com/signup/free).
* Fork the repository on GitHub.
* Install [Play with SBT](https://www.playframework.com/documentation/2.5.x/Installing). 
  * navigate to the project directory and run `sbt run` from the command line to initialize your app
  * navigate to `localhost:9000` to see the server running locally

## Making Changes

* Create a topic branch from where you want to base your work.
  * This is usually the master branch.
  * Only target release branches if you are certain your fix must be on that
    branch.
  * To quickly create a topic branch based on master, run `git checkout -b
    fix/master/my_contribution master`. Please avoid working directly on the
    `master` branch.
* Make commits of logical sizes.
* Make sure your commit messages are in the proper format. 
  ```
      Make the example in CONTRIBUTING imperative and concrete

      Without this patch applied the example commit message in the CONTRIBUTING
      document is not a concrete example. This is a problem because the
      contributor is left to imagine what the commit message should look like
      based on a description rather than an example. This patch fixes the
      problem by making the example concrete and imperative.

      The first line is a real-life imperative statement with a ticket number
      from our issue tracker. The body describes the behavior without the patch,
      why this is a problem, and how the patch fixes the problem when applied.
  ```
* Make sure you have added the necessary tests for your changes.
* Run _all_ the tests to assure nothing else was accidentally broken. First
  install all the test dependencies with `bundle install --path .bundle`. Then
  either run all the tests serially with `bundle exec rspec spec` or in parallel
  with `bundle exec rake parallel:spec[process_count]`

## Submitting Changes

* Push your changes to a topic branch in your fork of the repository.
* Submit a pull request to the repository in the puppetlabs organization.
* After feedback has been given we expect responses within two weeks. After two
  weeks we may close the pull request if it isn't showing any activity.

## Revert Policy

By running tests in advance and by engaging with peer review for prospective
changes, your contributions have a high probability of becoming long lived
parts of the the project. After being merged, the code will run through a
series of testing pipelines on a large number of operating system
environments. These pipelines can reveal incompatibilities that are difficult
to detect in advance.

If the code change results in a test failure, we will make our best effort to
correct the error. If a fix cannot be determined and committed within 24 hours
of its discovery, the commit(s) responsible _may_ be reverted, at the
discretion of the committer and Puppet maintainers. This action would be taken
to help maintain passing states in our testing pipelines.

## Summary

* Changes resulting in test pipeline failures will be reverted if they cannot
  be resolved within one business day.

(adapted from https://raw.githubusercontent.com/puppetlabs/puppet/master/CONTRIBUTING.md)

## Ways to contribute

- Stats calculators
  
  A more efficient method of calculating stats for team standings, full team, and individual
  standings can be implemented. 

- Testing
  
  Implementing JUnit testing would also be extremely beneficial, by creating a tournament, teams, matches, and players
  to simulate stats calculations.