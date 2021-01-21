# Relating the captured metric with our suggestions

## The `user` class
As stated in the [Quizes Tutor Complexity Analysis](./quizes_tutor_complexity_analysis.md), the `user` module contributes a great deal to the *XS* measurement of the entire `tutor` package and contributes exclusively with *fat*. This means the class is considered "bloated" according to the default *structure101*'s thresholds.

A suggestion of ours that would be of help concerning this issue is in the [Uses View's Rationale](../../module_view_uses.md#rationale), specifically *DMI2*, which states
> The user module has a lot of incoming uses dependencies, and therefore, In the future (and a possible solution to migrate quizzes-tutor into a microservices architecture), this module may be turned into an event publisher, publishing events to all the other modules.

This solution would decrease the `user` module (and class) and in turn reduce significantly the project's complexity.