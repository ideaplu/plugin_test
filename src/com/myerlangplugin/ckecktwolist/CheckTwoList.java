package com.myerlangplugin.ckecktwolist;



import com.fromGui.checkTwoList.RegularForm;
import com.fromGui.checkTwoList.ShowListForm;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import com.myerlangplugin.PluginHelper;
import com.utils.log.handle.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckTwoList extends AnAction {
    private Project project;
    private String packagePath1 = "";//文件路径1
    private String packagePath2 = "";//文件路径2
    @Override
    public void actionPerformed(AnActionEvent e) {
        DataContext dataContext = e.getDataContext();
        this.project = e.getData(PlatformDataKeys.PROJECT);
        String workpath = this.project.getBaseDir().getPath(); // 获取工作空间路径
//        Messages.showInfoMessage(project,"123 +" + text111,workpath);
        String url = CheckTwoList.getPath(dataContext);


        Log.debug("url " + url);

        Log.debug("workpath " + workpath);

        init(workpath,url);
    }

    /**
     *
     * @param workPath
     * @param filePath
     */
    private void init(String workPath,String filePath) {
//        try {
//            PluginHelper pluginHelper = PluginHelper.newInstance();
//            File targetDir = pluginHelper.prepareCodeGen(workPath,filePath);
//            String className = pluginHelper.getClassName(targetDir);
//            String tempPojoClassName = com.base.FileUtils.lowFirstChar(className);
//            String tempPojoName = com.base.FileUtils.upFirstChar(className);
//            String initValue = tempPojoClassName+" - "+tempPojoName+" -> targetPojoClass - targetPojo";

//            System.out.println("initValue" + initValue);

            initDialog();
//        } catch (IOException e) {
//            e.printStackTrace();
//            Messages.showInfoMessage(project, "Error", "出错." + e.getMessage());
//        }


    }


    private void initDialog() {
        RegularForm myDialog = new RegularForm(new RegularForm.DialogCallBack() {
            @Override
            public void ok(String scr1, String scr2,String pattern11, String pattern12,String pattern21, String pattern22){

                try {
                List<String> list1 = new ArrayList<String>();
                List<String> list2 = new ArrayList<String>();
//                    list1.add("1");
//                    list1.add("2");
//                    list1.add("3");
//                    list1.add("1");
//                    list1.add("2");
//                    list1.add("3");
//                    list1.add("1");
//                    list1.add("2");
//                    list1.add("3");
//                    list1.add("1");
//                    list1.add("2");
//                    list1.add("3");
//                    list1.add("1");
//                    list1.add("2");
//                    list1.add("3");
//                    list1.add("1");
//                    list1.add("2");
//                    list1.add("2");
//                    list1.add("3");
//                    list1.add("1");
//                    list1.add("2");
//                    list1.add("3");
//                    list1.add("1");
//                    list1.add("2");
//                    list1.add("3");
//                    list1.add("1");
//                    list1.add("2");
//                    list1.add("3");
//                    list1.add("1");
//                    list1.add("2");
//                    list1.add("3");
//                    list2.add("2");
//                    list2.add("3");
//                    list2.add("4");
                    // tang([^ling]*)ling
                    // Test1.java
                    // Test2.java
                CheckTwoListHelp checkTwoListHelp = new CheckTwoListHelp();
                checkTwoListHelp.checkfilelist(scr1,pattern11,pattern12,list1);
                checkTwoListHelp.checkfilelist(scr2,pattern21,pattern22,list2);
                ShowListForm showListForm = new ShowListForm(list1,list2);
                showListForm.setVisible(true);
                } catch (Exception e1) {
                e1.printStackTrace();
                Messages.showInfoMessage(project, e1.getMessage(), "io流出错." );
                e1.printStackTrace();
                }
            }
        });
        myDialog.setVisible(true);
    }

    public static String getPath(DataContext dataContext) {
        VirtualFile file = DataKeys.VIRTUAL_FILE.getData(dataContext);
        return file == null ? null : file.getPath();
    }

    public static void main(String[] args) {
        CheckTwoList checkTwoList = new CheckTwoList();
        checkTwoList.initDialog();
    }
}
