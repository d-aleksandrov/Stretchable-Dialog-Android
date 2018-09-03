# Stretchable-Dialog-Android
Example of dialog with stretched content body

Often I need dialog with transparent back without fixed size. It can be some text, image with unknown ratio, list of somethig. I can calculate the height, but Constraint Layout can to do it automatically. Small example:

```xml
<!--Main container with transparent background-->
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#33000000">

    <android.support.constraint.ConstraintLayout
        android:id="@+id/dialog_container"
        android:layout_width="match_parent"
        <!--Ok, i wrap to content-->
        android:layout_height="wrap_content"  
        <!-- But I have all constraints, my bias arrange me to bottom-->
        app:layout_constraintBottom_toTopOf="@id/dialog_ok"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="1.0"
        <!--And I have "match_constraint" max height and constrained Height flag!-->
        app:layout_constraintHeight_max="0dp"
        app:layout_constrainedHeight="true"/>

         <!--Button is fixed at the bottom-->
    <Button
        android:id="@+id/dialog_ok"
        android:layout_width="0dp"
        android:layout_height="50dp"
        android:background="#F00"
        android:textColor="#FFF"
        android:text="OK"
        android:textSize="17dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />

</android.support.constraint.ConstraintLayout>
```

That's all! I can attach to dialog_container some content, such as ScrollView(from fixed content), RecyclerView.
My window will shrink to size of content size, or limit size of the window size.


<img src="https://github.com/d-aleksandrov/Stretchable-Dialog-Android/blob/master/media/ezgif.com-video-to-gif.gif" width="320"/>
