var gulp = require('gulp'),
    sass = require('gulp-sass'),
    watch = require('gulp-watch'),
    connect = require('gulp-connect');

gulp.task('connect', function() {
    connect.server({
        root: 'dist',
        livereload: true
    });
});

gulp.task('pages', function() {
    gulp.src(['src/pages/*.html', 'src/pages/**/*.html'])
        .pipe(gulp.dest('dist'))
        .pipe(connect.reload());
});

gulp.task('scripts', function() {
    gulp.src('src/scripts/main.js')
        .pipe(gulp.dest('dist/js'))
        .pipe(connect.reload());
});

gulp.task('styles', function() {
    gulp.src('src/stylesheets/main.scss')
        .pipe(sass())
        .pipe(gulp.dest('dist/css'))
        .pipe(connect.reload());
});

gulp.task('watch', function() {
    watch({
        glob: 'src/scripts/**/*'
    }, ['scripts']);
    watch({
        glob: 'src/stylesheets/**/*'
    }, ['styles']);
    watch({
        glob: 'src/pages/**/*'
    }, ['pages'])
});

gulp.task('default', ['watch', 'connect']);