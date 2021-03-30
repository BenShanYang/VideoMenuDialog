package com.yk.videomenu;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @ClassName: PictureDialog
 * @Description: 选择视频的弹窗
 * @Author: YangKuan
 * @Date: 2021/3/1 14:26
 */
public abstract class VideoDialog extends Dialog implements View.OnClickListener {

    public VideoDialog(@NonNull Context context) {
        super(context, R.style.AlphaBaseDialogTheme);
        init();
    }

    public VideoDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        init();
    }

    public VideoDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    private void init() {
        setContentView(R.layout.dialog_video);
        windowConfig();
        findViewById(R.id.fl_album).setOnClickListener(VideoDialog.this);
        findViewById(R.id.fl_record).setOnClickListener(VideoDialog.this);
        findViewById(R.id.tv_cancel).setOnClickListener(VideoDialog.this);
    }

    private void windowConfig() {
        Window window = getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.BaseDialogWindowAnim);
            WindowManager.LayoutParams params = window.getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setAttributes(params);
            window.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fl_album) {
            album(VideoDialog.this);
        } else if (id == R.id.fl_record) {
            record(VideoDialog.this);
        } else if (id == R.id.tv_cancel) {
            if (isShowing()) {
                dismiss();
            }
        }
    }

    /**
     * 获取选择视频菜单按钮
     *
     * @return
     */
    public TextView getAlbumMenu() {
        return (TextView) findViewById(R.id.tv_album);
    }

    /**
     * 获取录制菜单按钮
     *
     * @return
     */
    public TextView getRecordMenu() {
        return (TextView) findViewById(R.id.tv_record);
    }

    /**
     * 设置选择视频菜单按钮文字
     *
     * @param text 菜单文字
     * @return
     */
    public VideoDialog setAlbumText(CharSequence text) {
        ((TextView) findViewById(R.id.tv_album)).setText(text);
        return VideoDialog.this;
    }

    /**
     * 设置录制菜单按钮文字
     *
     * @param text 菜单文字
     * @return
     */
    public VideoDialog setRecordText(CharSequence text) {
        ((TextView) findViewById(R.id.tv_record)).setText(text);
        return VideoDialog.this;
    }


    /**
     * 相册
     *
     * @param dialog
     */
    public abstract void album(VideoDialog dialog);

    /**
     * 拍照
     *
     * @param dialog
     */
    public abstract void record(VideoDialog dialog);

}
