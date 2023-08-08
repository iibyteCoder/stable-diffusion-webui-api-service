package com.testlab.model;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: stable-diffusion-webui-api-service
 * @Author: zyb
 * @CreateTime: 2023-08-08 15:54:20 星期二
 * @FileName: Txt2ImgVo
 * @Description: 用于接受txt2img参数
 */
public class Txt2ImgVo {
    private Boolean enable_hr;
    private Integer denoising_strength;
    private Integer firstphase_width;
    private Integer firstphase_height;
    private Integer hr_scale;
    private String hr_upscaler;
    private Integer hr_second_pass_steps;
    private Integer hr_resize_x;
    private Integer hr_resize_y;
    private String hr_sampler_name;
    private String hr_prompt;
    private String hr_negative_prompt;
    private String prompt;
    private List<String> styles;
    private Integer seed;
    private Integer subseed;
    private Integer subseed_strength;
    private Integer seed_resize_from_h;
    private Integer seed_resize_from_w;
    private String sampler_name;
    private Integer batch_size;
    private Integer n_iter;
    private Integer steps;
    private Integer cfg_scale;
    private Integer width;
    private Integer height;
    private Boolean restore_faces;
    private Boolean tiling;
    private Boolean do_not_save_samples;
    private Boolean do_not_save_grid;
    private String negative_prompt;
    private Integer eta;
    private Integer s_min_uncond;
    private Integer s_churn;
    private Integer s_tmax;
    private Integer s_tmin;
    private Integer s_noise;
    private Map<String, Object> override_settings;
    private Boolean override_settings_restore_afterwards;
    private List<String> script_args;
    private String sampler_index;
    private String script_name;
    private Boolean send_images;
    private Boolean save_images;
    private Map<String, Object> alwayson_scripts;

}
